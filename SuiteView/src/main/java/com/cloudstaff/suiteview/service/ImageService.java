package com.cloudstaff.suiteview.service;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.cloudstaff.suiteview.dynamodb.model.ImageItem;
import com.cloudstaff.suiteview.dynamodb.repositories.ImageItemDao;


@Service("imageService")
public class ImageService {
	@Autowired
	ImageItemDao imageItemDao;
	@Autowired
	AWSCredentials awsCredentials;
	public  List<ImageItem> getImageByCameraByDate(String cameraName,String date){
		List<ImageItem> list =null ;
		 try{

			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date t = sdf.parse(date);
			 long ltime=t.getTime()+1*24*60*60*1000;
			 list= imageItemDao.getImageByDate(cameraName, sdf.format(t),sdf.format(new Date(ltime)));
			 AmazonS3 s3client = new AmazonS3Client(awsCredentials);
			 java.util.Date expiration = new java.util.Date();
			
			 ImageItem item=null;
			 for(int i=0;i<list.size();i++){
				 item=list.get(i);
				 Date curr_dt = new Date();
				 sdf = new SimpleDateFormat("yyyy-MM-dd");
				 
				 if(item.getSignedUrlExp()==null){
					 ltime=curr_dt.getTime()+6*24*60*60*1000;
					 
					 generateSignedUrl(item, s3client,sdf.format(new Date(ltime)));
				 }
				 else if(item.getSignedUrlExp()!=null){
					 Date expDt = sdf.parse(item.getSignedUrlExp());
					 Date currdt = sdf.parse(sdf.format(curr_dt));
					 if(expDt.compareTo(currdt)<=0){
						 ltime=curr_dt.getTime()+6*24*60*60*1000;
						 generateSignedUrl(item, s3client,sdf.format(new Date(ltime)));
					 }
				 }
				 
			 }
				
		 }catch(AmazonServiceException  e){
			 e.printStackTrace();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return list;
	}
	public  List<ImageItem> getImageByCameraByDate(String cameraName,String date,String fromHour,String fromMinute, String toHour,String toMinute){
		List<ImageItem> list =null ;
		try{
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date t = sdf.parse(date);
			 long ltime=t.getTime()+1*24*60*60*1000;
			 list= imageItemDao.getImageByDate(cameraName, sdf.format(t),sdf.format(new Date(ltime)),fromHour,fromMinute,toHour,toMinute);
			 AmazonS3 s3client = new AmazonS3Client(awsCredentials);
		
			 ImageItem item=null;
			 for(int i=0;i<list.size();i++){
				 item=list.get(i);
				 Date curr_dt = new Date();
				 if(item.getSignedUrlExp()==null){
					 ltime=curr_dt.getTime()+6*24*60*60*1000;
					 
					 generateSignedUrl(item, s3client,sdf.format(new Date(ltime)));
				 }
				 else if(item.getSignedUrlExp()!=null){
					 Date expDt = sdf.parse(item.getSignedUrlExp());
					 Date currdt = sdf.parse(sdf.format(curr_dt));
					 if(expDt.compareTo(currdt)<=0){
						 ltime=curr_dt.getTime()+6*24*60*60*1000;
						 generateSignedUrl(item, s3client,sdf.format(new Date(ltime)));
					 }
				 }
				 
			 }
				
		 }catch(AmazonServiceException  e){
			 e.printStackTrace();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return list;
	}
	public List<ImageItem> getAllImageByCamera(String cameraName){
		try{
			return imageItemDao.getAllItemsByKey(cameraName, new ImageItem());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	private void generateSignedUrl(ImageItem item,AmazonS3 s3client,String expDt)throws Exception{
		
		java.util.Date expiration = new java.util.Date();
		long milliSeconds = expiration.getTime();
		milliSeconds += 7*24*60*60*1000; // Add 1 hour.
		expiration.setTime(milliSeconds);
		GeneratePresignedUrlRequest generatePresignedUrlRequest = 
			    new GeneratePresignedUrlRequest("imagessuiteview", item.getObjectKey());
		generatePresignedUrlRequest.setMethod(HttpMethod.GET); 
		generatePresignedUrlRequest.setExpiration(expiration);
		URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest); 
		item.setWebUrl(url.toString());
		item.setSignedUrlExp(expDt);
		imageItemDao.update(item);
	}

}
