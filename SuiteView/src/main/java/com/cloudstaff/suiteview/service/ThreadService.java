package com.cloudstaff.suiteview.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudstaff.suiteview.dynamodb.model.ThreadCommentItem;
import com.cloudstaff.suiteview.dynamodb.repositories.ThreadCommentItemDao;
import com.cloudstaff.suiteview.dynamodb.repositories.ThreadItemDao;

@Service("threadService")
public class ThreadService {
	@Autowired
	ThreadCommentItemDao threadCommentItemDao;
	@Autowired
	ThreadItemDao threadItemDao;
	public List<ThreadCommentItem> getThreadComment(String key){
		return threadCommentItemDao.getThreadComment(key);
	}
	public void saveComment(String threadKey,String username,String comment){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		ThreadCommentItem item = new ThreadCommentItem();
		item.setThreadkey(threadKey);
		item.setTimestamp(sdf.format(new Date()));
		item.setUsername(username);
		item.setComment(comment);
		threadCommentItemDao.save(item);
	}
}
