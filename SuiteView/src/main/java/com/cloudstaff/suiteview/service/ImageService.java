package com.cloudstaff.suiteview.service;

import java.net.URL;
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
		 List<ImageItem> list = imageItemDao.getImageByDate(cameraName, date);
		 
		 AmazonS3 s3client = new AmazonS3Client(awsCredentials);
		 try{
			 java.util.Date expiration = new java.util.Date();
			 long milliSeconds = expiration.getTime();
			 milliSeconds += 1000 * 60 * 60; // Add 1 hour.
			 expiration.setTime(milliSeconds);
			 for(int i=0;i<list.size();i++){
				 GeneratePresignedUrlRequest generatePresignedUrlRequest = 
						    new GeneratePresignedUrlRequest("imagessuiteview", list.get(i).getObjectKey());
					generatePresignedUrlRequest.setMethod(HttpMethod.GET); 
					generatePresignedUrlRequest.setExpiration(expiration);

					URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest); 

					System.out.println("Pre-Signed URL = " + url.toString());
			 }
				
		 }catch(AmazonServiceException  e){
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

}
