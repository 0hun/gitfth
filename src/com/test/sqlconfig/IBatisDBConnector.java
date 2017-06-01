package com.test.sqlconfig;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IBatisDBConnector {
	private static SqlMapClient client;
	
	private IBatisDBConnector(){}

	static {
		try {
			String resource = "com/test/sqlconfig/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			client=SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return client;
	}
}



