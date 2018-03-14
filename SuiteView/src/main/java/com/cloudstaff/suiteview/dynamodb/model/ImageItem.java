package com.cloudstaff.suiteview.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class ImageItem extends AbstractItem{
	private String cameraName;
	private String date;
	private String hour;
	private String min;
	private String objectKey;
	private String sec;
	private String webUrl;
	private String signedUrlExp;
	@DynamoDBHashKey(attributeName="cameraName")
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	@DynamoDBAttribute(attributeName="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@DynamoDBAttribute(attributeName="hour")
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@DynamoDBAttribute(attributeName="min")
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	@DynamoDBAttribute(attributeName="objectKey")
	public String getObjectKey() {
		return objectKey;
	}
	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}
	@DynamoDBAttribute(attributeName="sec")
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	@DynamoDBAttribute(attributeName="webUrl")
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	@DynamoDBAttribute(attributeName="signedUrlExp")
	public String getSignedUrlExp() {
		return signedUrlExp;
	}
	public void setSignedUrlExp(String signedUrlExp) {
		this.signedUrlExp = signedUrlExp;
	}
	
	
}
