package com.cloudstaff.suiteview.dynamodb.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.cloudstaff.suiteview.dynamodb.model.ThreadCommentItem;
import com.fasterxml.jackson.databind.ObjectMapper;
@Repository
public class ThreadCommentItemDao extends AbstractItemDao{
	private static final String TABLE="ThreadCommentSuiteView";
	
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}
	public List<ThreadCommentItem>getThreadComment(String key){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AttributeValue> expressionAttributeValues = 
			    new HashMap<String, AttributeValue>();
		expressionAttributeValues.put(":threadkey", new AttributeValue().withS(key));
		
		ScanRequest scanRequest = new ScanRequest()
				.withTableName(getTable())
				.withFilterExpression("threadkey = :threadkey")
				.withExpressionAttributeValues(expressionAttributeValues);
		ScanResult result = amazonDynamoDB.scan(scanRequest);
		List<ThreadCommentItem> itemList = new ArrayList<ThreadCommentItem>();
		for (Map<String, AttributeValue> item : result.getItems()) {
			try{
				itemList.add(mapper.readValue(printItem(item), ThreadCommentItem.class));
			}catch(Exception e){
				e.printStackTrace();
			}
		  
		}
		return itemList;
	}

}
