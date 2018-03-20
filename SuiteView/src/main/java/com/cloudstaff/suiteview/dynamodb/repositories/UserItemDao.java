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
	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}
}
