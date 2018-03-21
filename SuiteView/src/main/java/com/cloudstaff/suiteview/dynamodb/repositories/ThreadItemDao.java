package com.cloudstaff.suiteview.dynamodb.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class ThreadItemDao extends AbstractItemDao{
	private static final String TABLE="ThreadSuiteView";
	@Override
	protected String getTable() {
		// TODO Auto-generated method stub
		return TABLE;
	}

}
