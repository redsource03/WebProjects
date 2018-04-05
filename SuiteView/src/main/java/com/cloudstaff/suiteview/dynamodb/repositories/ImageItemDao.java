package com.cloudstaff.suiteview.dynamodb.repositories;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.util.StringUtils;
import com.cloudstaff.suiteview.dynamodb.model.ImageItem;
import com.fasterxml.jackson.databind.ObjectMapper;
@Repository
public class ImageItemDao extends AbstractItemDao{
	private static final String TABLE="ImagesSuiteView";
	@Autowired
	AmazonDynamoDB amazonDynamoDB;

	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}
	public List<ImageItem> getImageByDate(String cameraName,String date,String date2){
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		try{
			Table table = dynamoDB.getTable(this.getTable());
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#date", "date");
			QuerySpec spec = new QuerySpec().withKeyConditionExpression("cameraName = :v_cameraName and #date between :v_date1 and :v_date2" )
					.withValueMap(new ValueMap().withString(":v_cameraName", cameraName)
							.withString(":v_date1", date)
							.withString(":v_date2", date2)).withNameMap(expressionAttributeNames);
			ItemCollection<QueryOutcome> items = table.query(spec);
			Iterator<Item> iterator = items.iterator();
			List<ImageItem> list = new  ArrayList<ImageItem>();
			while (iterator.hasNext()) {
			  list.add(mapper.readValue(iterator.next().toJSONPretty(), ImageItem.class));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public List<ImageItem> getImageByBeforeDate(String cameraName,String date){
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		try{
			Table table = dynamoDB.getTable(this.getTable());
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#date", "date");
			QuerySpec spec = new QuerySpec().withKeyConditionExpression("cameraName = :v_cameraName and #date < :v_date1" )
					.withValueMap(new ValueMap().withString(":v_cameraName", cameraName)
							.withString(":v_date1", date)).withNameMap(expressionAttributeNames);
			ItemCollection<QueryOutcome> items = table.query(spec);
			Iterator<Item> iterator = items.iterator();
			List<ImageItem> list = new  ArrayList<ImageItem>();
			while (iterator.hasNext()) {
			  list.add(mapper.readValue(iterator.next().toJSONPretty(), ImageItem.class));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public List<ImageItem> getImageByDate(String cameraName,String date,String date2,String fromHour, String fromMinute, String toHour,String toMinute){
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		try{
			Table table = dynamoDB.getTable(this.getTable());
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#date", "date");
			

			QuerySpec spec = new QuerySpec().withKeyConditionExpression("cameraName = :v_cameraName and #date between :v_date1 and :v_date2" )
					
					.withValueMap(new ValueMap().withString(":v_cameraName", cameraName)
							.withString(":v_date1", date+"T"+fromHour+":"+fromMinute+":00Z")
							.withString(":v_date2", date+"T"+toHour+":"+toMinute+":00Z")
							).withNameMap(expressionAttributeNames);
			ItemCollection<QueryOutcome> items = table.query(spec);
			Iterator<Item> iterator = items.iterator();
			List<ImageItem> list = new  ArrayList<ImageItem>();
			while (iterator.hasNext()) {
			  list.add(mapper.readValue(iterator.next().toJSONPretty(), ImageItem.class));
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void deleteSingleImage (ImageItem item){
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		try{
			Table table = dynamoDB.getTable(this.getTable());
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#date", "date");
			DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
					.withPrimaryKey("cameraName",item.getCameraName(),"date",item.getDate());
			table.deleteItem(deleteItemSpec);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean update (ImageItem item) throws Exception{
		
		Map<String,AttributeValue> key =new HashMap<>();
		Map<String, AttributeValue> attributeValues = new HashMap<>();
		UpdateItemRequest updateItemRequest = new UpdateItemRequest();
		String expression ="set";
		Map<String, String> expressionAttributeNames = new HashMap<String, String>();
		expressionAttributeNames.put("#hour", "hour");
		expressionAttributeNames.put("#min", "min");
		expressionAttributeNames.put("#sec", "sec");
		Class myClass = item.getClass();
		
		key.put("cameraName", new AttributeValue().withS((String)item.getCameraName()));
		key.put("date", new AttributeValue().withS((String)item.getDate()));
		
		  Set set = key.entrySet();
	      
	      // Get an iterator
	      Iterator i = set.iterator();
	      Map.Entry mset1=null;
	      Map.Entry mset2=null;
	      // Display elements 
	      int counter=0;
	      while(i.hasNext()) {
	 
	         if(counter==0){
	        	 mset1 = (Map.Entry)i.next();
	         }else{
	        	 mset2=(Map.Entry)i.next();
	         }
	        counter++;
	      }
		updateItemRequest.withTableName(getTable()).withKey(mset1,mset2);
		for (Method method: myClass.getMethods()){
			if(method.getName().contains("get")){
				char[] chArr = method.getName().replaceAll("get", "").toCharArray();
				chArr[0] = Character.toLowerCase(chArr[0]);
				String s = new String(chArr);
				String v = s;
				if(s.equals("hour")||s.equals("date")||s.equals("min")||s.equals("sec")){
					s="#"+s;
				}
				 if (!"class".equalsIgnoreCase(s)) {
					if(method.getReturnType().equals(String.class)){
						if(!StringUtils.isNullOrEmpty((String)method.invoke(item))){
							if(!v.equals("date") && !v.equals("cameraName")){
								expression += "set".equals(expression)? " "+s+"=:"+v:" ,"+s+"=:"+v;
								attributeValues.put(":"+v, new AttributeValue().withS((String)method.invoke(item)));
							}
							
						}
					}else if(method.getReturnType().equals(ArrayList.class)){
						ArrayList<String> list = (ArrayList<String>)method.invoke(item);
						if(list!=null && list.size()>0){
							expression += "set".equals(expression)? " "+s+"=:"+v:" ,"+s+"=:"+v;
							attributeValues.put(":"+v, new AttributeValue().withSS(list));
						}
						
					}
					
				}
				
			}
		}
		updateItemRequest.withUpdateExpression(expression);
		updateItemRequest.withExpressionAttributeValues(attributeValues).withExpressionAttributeNames(expressionAttributeNames);
		UpdateItemResult updateItemResult = amazonDynamoDB.updateItem(updateItemRequest);
		if(updateItemResult!=null){
			return true;
		}
		
		return false;
	}

}
