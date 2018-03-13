package com.cloudstaff.suiteview.dynamodb.repositories;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
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
import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UserItemDao extends AbstractItemDao{
	
	private static final String TABLE="UsersSuiteView";
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	/*public boolean save(UserItem u){
		try{
			ArrayList<String> camList = new ArrayList<String>();
			camList.add("CAM1");
			camList.add("CAM2");
			camList.add("CAM99");
			DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
			Table table = dynamoDB.getTable(TABLE);
			Item item = new Item().withPrimaryKey("userKey", u.getUserKey())
					.withString("username", u.getUsername())
					.withString("firstname", u.getFirstname())
					.withString("lastname", u.getLastname())
					.withString("password", u.getPassword())
					.withString("email",u.getEmail())
					.withString("active",u.getActive())
					.withString("jobrole", u.getJobrole())
					.withString("account", u.getAccount())
					.withString("admin", u.getAdmin())
					.withList("cameralist", camList);
			table.putItem(item);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	public UserItem getUserByUsername(String username )throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		UserItem u= new UserItem();
		Table table = dynamoDB.getTable(this.getTable());
		u.setUsername(username);
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("userkey = :v_username" )
				.withValueMap(new ValueMap().withString(":v_username", DigestUtils.sha256Hex(username)));

		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		   return u=mapper.readValue(iterator.next().toJSONPretty(), UserItem.class);
		}
		
		return null;
	}
	/*public boolean updateUser(UserItem item){
		try{
			Class myClass = UserItem.class;
			for (Method method: myClass.getMethods()){
				if(method.getName().contains("get")){
				System.out.println(method.invoke(item, null));
				}
			}
			Map<String,AttributeValue> key =new HashMap<>();
			key.put("userKey", new AttributeValue().withS(item.getUserKey()));
			Map<String, AttributeValue> attributeValues = new HashMap<>();
			UpdateItemRequest updateItemRequest = new UpdateItemRequest();
			updateItemRequest.withTableName(TABLE).withKey(key);
			String expression ="set";
			if(!StringUtils.isNullOrEmpty(item.getFirstname())){
				attributeValues.put(":firstname", new AttributeValue().withS(item.getFirstname()));
				expression +=" firstname=:firstname";
			}
			if(!StringUtils.isNullOrEmpty(item.getLastname())){
				attributeValues.put(":lastname", new AttributeValue().withS(item.getLastname()));
				expression += "set".equals(expression)? " lastname=:lastname":" ,lastname=:lastname";
			}
			if(!StringUtils.isNullOrEmpty(item.getPassword())){
				attributeValues.put(":password", new AttributeValue().withS(item.getPassword()));
				expression += "set".equals(expression)? " password=:password":" ,password=:password";
			}
			if(item.getCameralist()!=null && item.getCameralist().size()>0){
				attributeValues.put(":cameralist", new AttributeValue().withSS(item.getCameralist()));
				expression += "set".equals(expression)? " cameralist=:cameralist":" ,cameralist=:cameralist";
			}
			if(!StringUtils.isNullOrEmpty(item.getActive())){
				attributeValues.put(":active", new AttributeValue().withS(item.getActive()));
				expression += "set".equals(expression)? " active=:active":" ,active=:active";
			}
			if(!StringUtils.isNullOrEmpty(item.getJobrole())){
				attributeValues.put(":jobrole", new AttributeValue().withS(item.getJobrole()));
				expression += "set".equals(expression)? " jobrole=:jobrole":" ,jobrole=:jobrole";
			}
			if(!StringUtils.isNullOrEmpty(item.getAccount())){
				attributeValues.put(":account", new AttributeValue().withS(item.getAccount()));
				expression += "set".equals(expression)? " account=:account":" ,account=:account";
			}
			updateItemRequest.withUpdateExpression(expression);
			updateItemRequest.withExpressionAttributeValues(attributeValues);
			UpdateItemResult updateItemResult = amazonDynamoDB.updateItem(updateItemRequest);
			if(updateItemResult!=null){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return false;
	}*/
	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}
}
