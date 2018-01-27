package com.cloudstaff.suiteview.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.cloudstaff.suiteview.forms.model.AddCameraFormModel;
import com.cloudstaff.suiteview.forms.model.AddUserFormModel;
import com.cloudstaff.suiteview.forms.model.userSearchForm;
import com.cloudstaff.suiteview.service.CameraService;
import com.cloudstaff.suiteview.service.UserService;

@RestController
@RequestMapping("/api")
public class SuiteViewApiController {
	@Autowired
	UserService userService;
	@Autowired
	CameraService cameraService;
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	@RequestMapping("/you")
	public  @ResponseBody String fundamentals() throws Exception{
		DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
		UserItem item = new UserItem();
		item.setUserKey("newtest");
		
		DynamoDBQueryExpression<UserItem> queryExpression = new DynamoDBQueryExpression<UserItem>()
			    .withHashKeyValues(item);

			List<UserItem> itemList = mapper.query(UserItem.class, queryExpression);

			for (int i = 0; i < itemList.size(); i++) {
			    System.out.println(itemList.get(i).getUserKey());
			    System.out.println(itemList.get(i).getUsername());
			}

		
		return "{\"Result\":\"OK\"}";
	}
	@RequestMapping(value="/addUser" , method=RequestMethod.POST)
	public @ResponseBody String addUser (@RequestBody  AddUserFormModel addUser){
		
		return "{\"Result\":\""+userService.addUser(addUser)+"\"}";
		
		
	}
	@RequestMapping(value="/addCamera",method=RequestMethod.POST)
	public @ResponseBody String addCamera (@RequestBody AddCameraFormModel addCamera){
		return "{\"Result\":\""+cameraService.addCamera(addCamera)+"\"}";
	}
	@RequestMapping(value="/userSearch",method=RequestMethod.POST)
	public @ResponseBody UserItem userSearch (@RequestBody userSearchForm userSearchForm){
		/**** add secuirity verify user ***/
		UserItem u = userService.getUser(userSearchForm.getUsername());
		if (u==null){
			u= new UserItem();
		}
		return u;
		
	}
	@RequestMapping("/getAllCamera")
	public @ResponseBody List<String> getAllCamera (){
		
		return cameraService.getAllCameraName();
		
		
	}
	@RequestMapping("/testUpdateUser")
	public void testUpdateUser(){
		AddUserFormModel model =  new AddUserFormModel();
		model.setUsername("redsource");
		model.setFname("Mariska Samantha");
		
		userService.updateUser(model);
		
	}
}
