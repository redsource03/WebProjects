package com.cloudstaff.suiteview.dynamodb.repositories;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

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
import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UserItemDao {
	
	private static final String TABLE="users";
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	public boolean save(UserItem u){
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
	}
	public UserItem getUserByUsername(String username )throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable(TABLE);
		UserItem u= new UserItem();
		u.setUsername(username);
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("userKey = :v_username" )
				.withValueMap(new ValueMap().withString(":v_username", DigestUtils.sha256Hex(username)));

		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		   return u=mapper.readValue(iterator.next().toJSONPretty(), UserItem.class);
		}
		
		return null;
	}
}
