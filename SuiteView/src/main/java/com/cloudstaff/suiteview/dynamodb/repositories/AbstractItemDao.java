package com.cloudstaff.suiteview.dynamodb.repositories;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.util.StringUtils;
import com.cloudstaff.suiteview.dynamodb.model.AbstractItem;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractItemDao {
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	protected abstract String getTable();
	public <T extends AbstractItem> T getItemByKey(String key, T item) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable(getTable());
		Class myClass = item.getClass();
		String s="";
		for (Method method: myClass.getMethods()){
			/*if(method.getName().contains("get") && method.getName().contains("key")){
				char[] chArr = method.getName().replaceAll("get", "").toCharArray();
				chArr[0] = Character.toLowerCase(chArr[0]);
				s = new String(chArr);
				break;
			}*/
			if(method.isAnnotationPresent(DynamoDBHashKey.class)){
				DynamoDBHashKey keyName = method.getAnnotation(DynamoDBHashKey.class);
				s=keyName.attributeName();
				break;
			}
		}
		QuerySpec spec = new QuerySpec().withKeyConditionExpression(s+"=:v_"+s )
				.withValueMap(new ValueMap().withString(":v_"+s, key));

		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		   return  (T) mapper.readValue(iterator.next().toJSONPretty(), item.getClass());
		}
		
		return null;
	}
	public <T extends AbstractItem> List<T>   getAllItemsByKey(String key, T item) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable(getTable());
		Class myClass = item.getClass();
		String s="";
		for (Method method: myClass.getMethods()){
			if(method.isAnnotationPresent(DynamoDBHashKey.class)){
				DynamoDBHashKey keyName = method.getAnnotation(DynamoDBHashKey.class);
				s=keyName.attributeName();
				break;
			}
		}
		QuerySpec spec = new QuerySpec().withKeyConditionExpression(s+"=:v_"+s )
				.withValueMap(new ValueMap().withString(":v_"+s, key));

		ItemCollection<QueryOutcome> items = table.query(spec);
		List<T> list = new ArrayList<T>();
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		   list.add(  (T) mapper.readValue(iterator.next().toJSONPretty(), item.getClass()));
		}
		
		return list;
	}
	public <T extends AbstractItem>boolean save (T item){
		try{
			DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
			Table table = dynamoDB.getTable(getTable());
			Class myClass = item.getClass();
			for (Method method: myClass.getMethods()){
				if(method.getName().contains("get") && method.getName().contains("key")){
					char[] chArr = method.getName().replaceAll("get", "").toCharArray();
					chArr[0] = Character.toLowerCase(chArr[0]);
					String s = new String(chArr);
					Item item2 = new Item().withPrimaryKey(s,(String)method.invoke(item));
					table.putItem(item2);
					break;
				}
			}
			update(item);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public <T extends AbstractItem>boolean update (T item) throws Exception{
		
		Map<String,AttributeValue> key =new HashMap<>();
		Map<String, AttributeValue> attributeValues = new HashMap<>();
		UpdateItemRequest updateItemRequest = new UpdateItemRequest();
		String expression ="set";
		Class myClass = item.getClass();
		for (Method method: myClass.getMethods()){
			if(method.getName().contains("get")){
				char[] chArr = method.getName().replaceAll("get", "").toCharArray();
				chArr[0] = Character.toLowerCase(chArr[0]);
				String s = new String(chArr);
				if(method.isAnnotationPresent(DynamoDBHashKey.class)){
					key.put(s,  new AttributeValue().withS((String)method.invoke(item)));
					updateItemRequest.withTableName(getTable()).withKey(key);
				}else if (!"class".equalsIgnoreCase(s)) {
					if(method.getReturnType().equals(String.class)){
						if(!StringUtils.isNullOrEmpty((String)method.invoke(item))){
							expression += "set".equals(expression)? " "+s+"=:"+s:" ,"+s+"=:"+s;
							attributeValues.put(":"+s, new AttributeValue().withS((String)method.invoke(item)));
						}
					}else if(method.getReturnType().equals(ArrayList.class)){
						ArrayList<String> list = (ArrayList<String>)method.invoke(item);
						if(list!=null && list.size()>0){
							expression += "set".equals(expression)? " "+s+"=:"+s:" ,"+s+"=:"+s;
							attributeValues.put(":"+s, new AttributeValue().withSS(list));
						}
						
					}
					
				}
				
			}
		}
		updateItemRequest.withUpdateExpression(expression);
		updateItemRequest.withExpressionAttributeValues(attributeValues);
		UpdateItemResult updateItemResult = amazonDynamoDB.updateItem(updateItemRequest);
		if(updateItemResult!=null){
			return true;
		}
		
		return false;
	}
}
