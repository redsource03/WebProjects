package com.cloudstaff.suiteview.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="ThreadCommentSuiteView")
public class ThreadCommentItem extends AbstractItem{
	
	private String threadkey;
	private String timestamp;
	private String comment;
	private String username;
	@DynamoDBHashKey(attributeName = "threadkey")
	public String getThreadkey() {
		return threadkey;
	}
	public void setThreadkey(String threadkey) {
		this.threadkey = threadkey;
	}
	@DynamoDBRangeKey(attributeName = "timestamp")
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@DynamoDBAttribute(attributeName="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@DynamoDBAttribute(attributeName="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
