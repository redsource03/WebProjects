package com.cloudstaff.suiteview.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

public class SessionUtil {
	private static final String  ACCESS_TOKEN_SALT="ioewuvirn23u804723v0942397";
	private static final String TOKEN_ADDER="oi12uvo123812938v1054129048123";
	public static String isAlreadyLogin(HttpServletRequest request){
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		String cookiename= DigestUtils.sha256Hex(modifiedDate+ACCESS_TOKEN_SALT);
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return null;
		}
		for(int i = 0; i < cookies.length; i++) { 
            Cookie cookie1 = cookies[i];
            if (cookie1.getName().equals(cookiename)) {
                return  cookie1.getValue().replace(TOKEN_ADDER, "");
            }
        }  
		return null;
	}
	public static void setAccessToken ( HttpServletResponse response,String token){
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		Cookie cook = new Cookie(DigestUtils.sha256Hex(modifiedDate+ACCESS_TOKEN_SALT), token+TOKEN_ADDER);
		cook.setMaxAge(24*60*60); /// 1 Day
		response.addCookie(cook);
	}
	public static void removeAccesToken (HttpServletRequest request,HttpServletResponse response){
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		String cookiename= DigestUtils.sha256Hex(modifiedDate+ACCESS_TOKEN_SALT);
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i = 0; i < cookies.length; i++) { 
	            Cookie cookie1 = cookies[i];
	            if (cookie1.getName().equals(cookiename)) {
	               cookie1.setValue("");
	               cookie1.setPath("/");
	               cookie1.setMaxAge(0);
	               response.addCookie(cookie1);
	            }
	        }  
		}
		
	}
	
}
