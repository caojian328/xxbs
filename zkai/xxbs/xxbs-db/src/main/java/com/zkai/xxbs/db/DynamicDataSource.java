package com.zkai.xxbs.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource  {

	static final String MASTER = "master";
	static final String SLAVE = "slave";

	private static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	@Override
	protected Object determineCurrentLookupKey() {
		
		return holder.get();
	}

    public static void putDataSource(String name) {

    	holder.set(name);
    }
}
