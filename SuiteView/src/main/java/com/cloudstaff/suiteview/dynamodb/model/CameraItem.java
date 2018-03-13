package com.cloudstaff.suiteview.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="CamerasSuiteView")
public class CameraItem extends AbstractItem{
	private String cameraKey;
	private String cameraName;
	private String active;
	private String cameraInformation;
	private String cameraLocation;
	@DynamoDBHashKey(attributeName="camerakey")
	public String getCamerakey() {
		return cameraKey;
	}
	public void setCamerakey(String cameraKey) {
		this.cameraKey = cameraKey;
	}
	@DynamoDBAttribute(attributeName="cameraName")
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	@DynamoDBAttribute(attributeName="active")
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@DynamoDBAttribute(attributeName="cameraInformation")
	public String getCameraInformation() {
		return cameraInformation;
	}
	public void setCameraInformation(String cameraInformation) {
		this.cameraInformation = cameraInformation;
	}
	@DynamoDBAttribute(attributeName="cameraLocation")
	public String getCameraLocation() {
		return cameraLocation;
	}
	public void setCameraLocation(String cameraLocation) {
		this.cameraLocation = cameraLocation;
	}
	
	

}
