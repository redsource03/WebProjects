package com.cloudstaff.suiteview.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.cloudstaff.suiteview.forms.model.AddCameraFormModel;
import com.cloudstaff.suiteview.forms.model.AddRemoveCameraFormModel;
import com.cloudstaff.suiteview.forms.model.AddUserFormModel;
import com.cloudstaff.suiteview.forms.model.LogInForm;
import com.cloudstaff.suiteview.forms.model.userSearchForm;
import com.cloudstaff.suiteview.service.CameraService;
import com.cloudstaff.suiteview.service.UserService;
import com.cloudstaff.suiteview.utils.SessionUtil;

@Controller
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
	public @ResponseBody String addUser (@RequestBody  AddUserFormModel addUser,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			return "{\"Result\":\""+userService.addUser(addUser)+"\"}";
		}else{
			 return "{\"Result\":\"User has no Access to this feature\"}";
		}
		
		
	}
	@RequestMapping(value="/addCamera",method=RequestMethod.POST)
	public @ResponseBody String addCamera (@RequestBody AddCameraFormModel addCamera,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			return "{\"Result\":\""+cameraService.addCamera(addCamera)+"\"}";
		}else{
			 return "{\"Result\":\"User has no Access to this feature\"}";
		}
	}
	@RequestMapping(value="/userSearch",method=RequestMethod.POST)
	public @ResponseBody UserItem userSearch (@RequestBody userSearchForm userSearchForm,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			UserItem u = userService.getUser(userSearchForm.getUsername());
			if (u==null){
				u= new UserItem();
			}
			return u;
		}else{
			 return new UserItem();
		}
		
		
	}
	@RequestMapping("/getAllCamera")
	public @ResponseBody List<String> getAllCamera (HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			return cameraService.getAllCameraName();
		}else{
			 return new ArrayList<String>();
		}
		
		
		
	}
	@RequestMapping(value="/removeCameraUser",method=RequestMethod.POST)
	public @ResponseBody UserItem removeCameraUser (@RequestBody  AddRemoveCameraFormModel rm,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			return userService.removeCameraFromUser(rm.getUsername(), rm.getCameraname());
		}else{
			 return new UserItem();
		}
		
		
	}
	@RequestMapping(value="/addCameraUser",method=RequestMethod.POST)
	public @ResponseBody UserItem addCameraUser (@RequestBody  AddRemoveCameraFormModel rm,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		if(key!=null && userService.getUserByKey(key).getAdmin().equalsIgnoreCase("Y")){
			return userService.addCameraFromUser(rm.getUsername(), rm.getCameraname());
		}else{
			 return new UserItem();
		}
		
		
	}
	
}
