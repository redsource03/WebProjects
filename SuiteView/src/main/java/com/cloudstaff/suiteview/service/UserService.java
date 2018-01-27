package com.cloudstaff.suiteview.service;


import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.cloudstaff.suiteview.dynamodb.repositories.UserItemDao;
import com.cloudstaff.suiteview.forms.model.AddUserFormModel;

@Service("userService")
public class UserService {
	/*@Autowired
	UserDao userDao;*/
	@Autowired
	UserItemDao userDao;
	public UserItem verifyLogin(String username, String password){
		UserItem u = null;
		try{
			u =userDao.getUserByUsername(username);
			if(u!=null) {
				if(DigestUtils.sha256Hex(password).equals(u.getPassword())){
					return u;
				}else return null;
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return null;
	}
	/*public String setAccesstoken(User user,HttpServletResponse response){
		String currdate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String access=DigestUtils.sha256Hex(currdate+user.getPassword());
		Cookie cook = new Cookie("suiteViewToken",access);
		cook.setMaxAge(24 * 60 * 60);
		response.addCookie(cook);
		return access;
	}*/
	public UserItem getUser(String username){
		UserItem u = null;
		try{
			u =userDao.getUserByUsername(username);
			if(u!=null) return u;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public String addUser(AddUserFormModel uForm){
		UserItem userDaoModel = new UserItem();
		userDaoModel.setAccount(uForm.getAccount());
		userDaoModel.setActive("Y"); //<--- needs to be change to userID of the admin
		userDaoModel.setAdmin("N");//<------ Needs to be changed
		// create a java calendar instance
		userDaoModel.setEmail(uForm.getEmail());
		userDaoModel.setFirstname(uForm.getFname());
		userDaoModel.setJobrole(uForm.getJobRole());
		userDaoModel.setLastname(uForm.getLname());
		userDaoModel.setPassword(DigestUtils.sha256Hex(uForm.getPassword()));
		userDaoModel.setUsername(uForm.getUsername());
		userDaoModel.setUserKey(DigestUtils.sha256Hex(uForm.getUsername()));
		try{
			if(userDao.getUserByUsername(userDaoModel.getUsername())==null){
				userDao.save(userDaoModel);
			}else{
				return "username already Exist";
					
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			return "Exception Occured";
		}
		
		return "OK";
	}
	public String updateUser(AddUserFormModel uForm){
		UserItem userDaoModel = new UserItem();
		userDaoModel.setAccount(uForm.getAccount());
		userDaoModel.setActive("Y"); //<--- needs to be change to userID of the admin
		userDaoModel.setAdmin("N");//<------ Needs to be changed
		// create a java calendar instance
		userDaoModel.setEmail(uForm.getEmail());
		userDaoModel.setFirstname(uForm.getFname());
		userDaoModel.setJobrole(uForm.getJobRole());
		userDaoModel.setLastname(uForm.getLname());
		//userDaoModel.setPassword(DigestUtils.sha256Hex(uForm.getPassword()));
		userDaoModel.setUsername(uForm.getUsername());
		userDaoModel.setUserKey(DigestUtils.sha256Hex(uForm.getUsername()));
		ArrayList<String> list = new ArrayList<>();
		list.add("ASD1");
		list.add("ASD2");
		list.add("ASD3");
		userDaoModel.setCameralist(list);
		userDao.updateUser(userDaoModel);
		
		
		return "OK";
		
	}

}
