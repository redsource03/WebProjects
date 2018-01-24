package com.cloudstaff.suiteview.dynamodb.model;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="users")
public class UserItem {
	private String userKey;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String active;
	private String jobrole;
	private String account;
	private String admin;
	private ArrayList<String> cameralist;
	@DynamoDBHashKey(attributeName="userkey")
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	@DynamoDBAttribute(attributeName="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@DynamoDBAttribute(attributeName="firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	@DynamoDBAttribute(attributeName="lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	@DynamoDBAttribute(attributeName="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@DynamoDBAttribute(attributeName="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@DynamoDBAttribute(attributeName="active")
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@DynamoDBAttribute(attributeName="jobrole")
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobRole) {
		this.jobrole = jobRole;
	}
	@DynamoDBAttribute(attributeName="account")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@DynamoDBAttribute(attributeName="admin")
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@DynamoDBAttribute(attributeName="cameralist")
	public ArrayList<String> getCameralist() {
		return cameralist;
	}
	public void setCameralist(ArrayList<String> cameralist) {
		this.cameralist = cameralist;
	}
	
	
	
}
