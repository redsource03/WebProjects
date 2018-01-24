package com.cloudstaff.suiteview.service;


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
			if(u!=null) return u;
			
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

}
