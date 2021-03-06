package com.cloudstaff.suiteview.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cloudstaff.suiteview.dynamodb.model.ImageItem;
import com.cloudstaff.suiteview.dynamodb.model.ThreadCommentItem;
import com.cloudstaff.suiteview.dynamodb.model.ThreadItem;
import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.cloudstaff.suiteview.forms.model.AddCameraFormModel;
import com.cloudstaff.suiteview.forms.model.AddRemoveCameraFormModel;
import com.cloudstaff.suiteview.forms.model.AddUserFormModel;
import com.cloudstaff.suiteview.forms.model.ImageForm;
import com.cloudstaff.suiteview.forms.model.ImageSearchForm;
import com.cloudstaff.suiteview.forms.model.ThreadForm;
import com.cloudstaff.suiteview.forms.model.userSearchForm;
import com.cloudstaff.suiteview.service.CameraService;
import com.cloudstaff.suiteview.service.ImageService;
import com.cloudstaff.suiteview.service.ThreadService;
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
	ImageService imageService;
	@Autowired
	ThreadService threadService;
	@Autowired
	AmazonDynamoDB amazonDynamoDB;
	@RequestMapping("/you")
	public  @ResponseBody String fundamentals() throws Exception{
		
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
	@RequestMapping(value="/updateUser" , method=RequestMethod.POST)
	public @ResponseBody String updateUser (@RequestBody  AddUserFormModel uform,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item = userService.getUserByKey(key);
		if(key!=null && item.getAdmin().equalsIgnoreCase("Y")){ //admin
			
			return "{\"Result\":\"User has been updated\"}";
			//return "{\"Result\":\""+userService.addUser(addUser)+"\"}";
		}else if (item.getUsername().equals(uform.getUsername())){ // user update
			uform.setUsername(item.getUsername());
			userService.updateUser(uform);
			return "{\"Result\":\"User has been updated\"}";
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
	@RequestMapping(value="/getCurrentUser",method=RequestMethod.POST)
	public @ResponseBody UserItem getCurrentUser (HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		item.setPassword("");
		if(key!=null){
			return item;
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
	@RequestMapping("/getCameraUser")
	public @ResponseBody List<String> getCameraUser(HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(key!=null && item.getAdmin().equalsIgnoreCase("Y")){
			return cameraService.getAllCameraName();
		}else if (key!=null ) {
			return item.getCameralist();
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
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody List<ImageItem> test (){
		return imageService.getImageByCameraByDate("crk90-ctv-008","2018-02-16");
		
	}
	@RequestMapping(value="/searchImageByCDT",method=RequestMethod.POST)
	public @ResponseBody List<ImageItem> searchImageByByCDT(@RequestBody  ImageSearchForm im,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(key!=null && item.getAdmin().equalsIgnoreCase("Y")){
			return imageService.getImageByCameraByDate(im.getCameraName(), im.getDate(),im.getFromHour(),im.getFromMinute(),im.getToHour(),im.getToMinute());
		}else if(item.getCameralist()!=null){
			for(int i=0;i<item.getCameralist().size();i++){ //Not admin but have access
				if(item.getCameralist().get(i).equalsIgnoreCase(im.getCameraName())){
					return imageService.getImageByCameraByDate(im.getCameraName(), im.getDate(),im.getFromHour(),im.getFromMinute(),im.getToHour(),im.getToMinute());
				}
			}
		}else{
			 return null;
		}
		 return null;
	}
	@RequestMapping(value="/createThread",method=RequestMethod.POST)
	public @ResponseBody String createThread(@RequestBody  ThreadForm tf,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(item!=null){
			tf.setUsername(item.getUsername());
			threadService.createThread(tf);
		}
		return "{\"Result\":\"OK\"}";
	}
	@RequestMapping(value="/createComment",method=RequestMethod.POST)
	public @ResponseBody String createComment(@RequestBody ThreadForm tf, HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(item!=null){
			tf.setUsername(item.getUsername());
			threadService.saveComment(tf);
		}
		return "{\"Result\":\"OK\"}";
	}
	@RequestMapping(value="/getUserThread",method=RequestMethod.POST)
	public @ResponseBody List<ThreadItem> getUserThread(HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(item!=null){
			return threadService.getThreadByUser(item);
		}
		return null;
	}
	@RequestMapping(value="/getThreadComment",method=RequestMethod.POST)
	public @ResponseBody List<ThreadCommentItem> getThreadComment(@RequestBody ThreadForm tf,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		if(item!=null){
			return threadService.getThreadComment(tf.getThreadkey());
		}
		return null;
	}
	@RequestMapping(value="/deleteImage",method=RequestMethod.POST)
	public @ResponseBody String deleteImage(@RequestBody ImageForm IF,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		try{
			if(item!=null && item.getAdmin().equals("Y")){
				imageService.deleteImage(IF);
			}
		}catch(Exception e){
			e.printStackTrace();
			return "{\"Result\":\"Failed to delete image.\"}";
		} 
		
		return "{\"Result\":\"Image has been deleted.\"}";
	}
	@RequestMapping(value="/deleteImageBefore",method=RequestMethod.POST)
	public @ResponseBody String deleteImageBefore(@RequestBody ImageForm IF,HttpServletRequest request){
		String key =SessionUtil.isAlreadyLogin(request);
		UserItem item =userService.getUserByKey(key);
		try{
			if(item!=null && item.getAdmin().equals("Y")){
				imageService.deleteImageBefore(IF.getCameraName(), IF.getDate());;
			}
		}catch(Exception e){
			e.printStackTrace();
			return "{\"Result\":\"Failed to delete images.\"}";
		} 
		
		return "{\"Result\":\"Images has been deleted.\"}";
	}
}
