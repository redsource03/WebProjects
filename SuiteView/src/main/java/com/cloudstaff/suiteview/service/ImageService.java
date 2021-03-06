package com.cloudstaff.suiteview.service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.cloudstaff.suiteview.dynamodb.model.ImageItem;
import com.cloudstaff.suiteview.dynamodb.repositories.ImageItemDao;
import com.cloudstaff.suiteview.forms.model.ImageForm;


@Service("imageService")
public class ImageService {
	private final static String BUCKET_NAME="imagessuiteview";
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
			    new GeneratePresignedUrlRequest(BUCKET_NAME, item.getObjectKey());
		generatePresignedUrlRequest.setMethod(HttpMethod.GET); 
		generatePresignedUrlRequest.setExpiration(expiration);
		URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest); 
		item.setWebUrl(url.toString());
		item.setSignedUrlExp(expDt);
		imageItemDao.update(item);
	}
	public void deleteImage(ImageForm iF){
		AmazonS3 s3client = new AmazonS3Client(awsCredentials);
		ImageItem item = new ImageItem();
		item.setCameraName(iF.getCameraName());
		item.setDate(iF.getDate());
		//imageItemDao.deleteSingleImage(item);
		//deleteS3Image(s3client, iF.getObjectKey());
	}
	public void deleteImageBefore(String cameraName,String date){
		AmazonS3 s3client = new AmazonS3Client(awsCredentials);
		List<ImageItem> list = imageItemDao.getImageByBeforeDate(cameraName, date);
		for(ImageItem item: list){
			//imageItemDao.deleteSingleImage(item);
			//deleteS3Image(s3client, item.getObjectKey());
		}
			
	}
	private void deleteS3Image (AmazonS3 s3client,String objectKey){
		try {
			s3client.deleteObject(new DeleteObjectRequest(BUCKET_NAME, objectKey));
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException.");
            System.out.println("Error Message: " + ace.getMessage());
        }
	}

}
