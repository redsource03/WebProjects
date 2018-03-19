package com.cloudstaff.suiteview.forms.model;

public class ImageSearchForm {
	private String date;
	private String cameraName;
	private String fromHour;
	private String fromMinute;
	private String toHour;
	private String toMinute;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getFromHour() {
		if(fromHour.length()==1){
			this.fromHour = "0"+fromHour;
		}
		return fromHour;
	}
	public void setFromHour(String fromHour) {
		this.fromHour = fromHour;
	}
	public String getFromMinute() {
		if(fromMinute.length()==1){
			this.fromMinute = "0"+fromMinute;
		}
		return fromMinute;
	}
	public void setFromMinute(String fromMinute) {
		this.fromMinute = fromMinute;
	}
	public String getToHour() {
		if(toHour.length()==1){
			this.toHour = "0"+toHour;
		}
		return toHour;
	}
	public void setToHour(String toHour) {
		this.toHour = toHour;
	}
	public String getToMinute() {
		if(toMinute.length()==1){
			this.toMinute = "0"+toMinute;
		}
		return toMinute;
	}
	public void setToMinute(String toMinute) {
		this.toMinute = toMinute;
	}
	
	
}
