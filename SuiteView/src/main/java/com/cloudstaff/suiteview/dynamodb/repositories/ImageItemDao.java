package com.cloudstaff.suiteview.dynamodb.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
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
	public List<ImageItem> getImageByDate(String cameraName,String date){
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		
		try{
			Table table = dynamoDB.getTable(this.getTable());
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#date", "date");
			QuerySpec spec = new QuerySpec().withKeyConditionExpression("cameraName = :v_cameraName and #date between :v_date1 and :v_date2" )
					.withValueMap(new ValueMap().withString(":v_cameraName", cameraName)
							.withString(":v_date1", "2018-02-16")
							.with(":v_date2", "2018-02-17")).withNameMap(expressionAttributeNames);
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

}
