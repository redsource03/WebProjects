package com.cloudstaff.suiteview.dynamodb.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.cloudstaff.suiteview.dynamodb.model.ThreadItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ThreadItemDao extends AbstractItemDao{
	private static final String TABLE="ThreadSuiteView";
	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}
	public ThreadItem getThreadTimeStamp(String timestamp,String username){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AttributeValue> expressionAttributeValues = 
			    new HashMap<String, AttributeValue>();
		Map<String, String> expressionAttributeNames = new HashMap<String, String>();
		expressionAttributeNames.put("#timestamp", "timestamp");
		expressionAttributeValues.put(":timestamp", new AttributeValue().withS(timestamp));
		expressionAttributeValues.put(":username",new AttributeValue().withS(username));
		ScanRequest scanRequest = new ScanRequest()
				.withTableName(getTable())
				.withFilterExpression("#timestamp = :timestamp AND username = :username")
				.withExpressionAttributeValues(expressionAttributeValues)
				.withExpressionAttributeNames(expressionAttributeNames);
		ScanResult result = amazonDynamoDB.scan(scanRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {
			try{
				return mapper.readValue(printItem(item), ThreadItem.class);
			}catch(Exception e){
				e.printStackTrace();
			}
		  
		}
		return null;
	}
	public List<ThreadItem> getAllThreadUser(String username){
		ObjectMapper mapper = new ObjectMapper();
		List<ThreadItem> itemList = new ArrayList<ThreadItem>();
		Map<String, AttributeValue> expressionAttributeValues = 
			    new HashMap<String, AttributeValue>();
		expressionAttributeValues.put(":username",new AttributeValue().withS(username));
		ScanRequest scanRequest = new ScanRequest()
				.withTableName(getTable())
				.withFilterExpression("username = :username")
				.withExpressionAttributeValues(expressionAttributeValues);
		ScanResult result = amazonDynamoDB.scan(scanRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {
			try{
				itemList.add( mapper.readValue(printItem(item), ThreadItem.class));
			}catch(Exception e){
				e.printStackTrace();
			}
		  
		}
		return itemList;
	}

}
