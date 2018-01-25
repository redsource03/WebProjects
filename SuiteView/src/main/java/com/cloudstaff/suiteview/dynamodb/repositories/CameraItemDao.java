package com.cloudstaff.suiteview.dynamodb.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;
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
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.cloudstaff.suiteview.dynamodb.model.CameraItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CameraItemDao {
	private static final String TABLE="cameras";
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	public boolean save (CameraItem c){
		try{
			DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
			Table table = dynamoDB.getTable(TABLE);
			Item item = new Item().withPrimaryKey("cameraKey", c.getCameraKey())
					.withString("cameraName",c.getCameraName())
					.withString("active", c.getActive())
					.withString("cameraInformation",c.getCameraInformation())
					.withString("cameraLocation", c.getCameraLocation())
					;
			table.putItem(item);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public CameraItem getCameraByName(String cameraName)throws Exception{
		CameraItem c =null;
		
		ObjectMapper mapper = new ObjectMapper();
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable(TABLE);
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("cameraKey = :v_cameraKey" )
				.withValueMap(new ValueMap().withString(":v_cameraKey", DigestUtils.sha256Hex(cameraName)));
		ItemCollection<QueryOutcome> items = table.query(spec);
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
		   return c=mapper.readValue(iterator.next().toJSONPretty(), CameraItem.class);
		}
		
		return c;
	}
	public List<CameraItem> getAllCamera(){
		try{
			ObjectMapper mapper = new ObjectMapper();
			List<CameraItem> camArr =  new ArrayList<CameraItem>();
			ScanRequest scanRequest = new ScanRequest()
				    .withTableName(TABLE);
				ScanResult result = amazonDynamoDB.scan(scanRequest);
				for (Map<String, AttributeValue> item : result.getItems()){
					camArr.add(mapper.readValue(printItem(item), CameraItem.class));
				}
				if (camArr.size()!=0) return camArr;
		}catch(Exception e){
			 e.printStackTrace();
			 return null;
		}
		return null;
	}
	private static String printItem(Map<String, AttributeValue> attributeList) throws JSONException{
        JSONObject json = new JSONObject();
        for (Map.Entry<String, AttributeValue> item : attributeList.entrySet()) {
            String attributeName = item.getKey();
            AttributeValue value = item.getValue();
            if(value.getS()!=null){
            	json.put(attributeName, value.getS());
            }
        }
        return json.toString();
    }
}
