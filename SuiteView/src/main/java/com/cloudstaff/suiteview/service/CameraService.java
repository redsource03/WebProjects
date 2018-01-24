package com.cloudstaff.suiteview.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudstaff.suiteview.dynamodb.model.CameraItem;
import com.cloudstaff.suiteview.dynamodb.repositories.CameraItemDao;
import com.cloudstaff.suiteview.forms.model.AddCameraFormModel;

@Service("cameraService")
public class CameraService {
	@Autowired
	CameraItemDao cameraItemDao;
	
	public String addCamera(AddCameraFormModel cModel){
		CameraItem cam = new CameraItem();
		cam.setActive("Y");
		cam.setCameraInformation(cModel.getCameraInformation());
		cam.setCameraName(cModel.getCameraName());
		cam.setCameraLocation(cModel.getLocation());
		cam.setCameraKey(DigestUtils.sha256Hex(cModel.getCameraName()));
		
		try{
			if(cameraItemDao.getCameraByName(cam.getCameraName())==null ){
				cameraItemDao.save(cam);
			}else{
				return "CameraName Already Exist";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return "Exception Occured";
		}
		return "Camera has been Added";
	}


}
