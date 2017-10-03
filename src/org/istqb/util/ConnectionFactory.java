package org.istqb.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public final class ConnectionFactory {
	
	private static ConnectionFactory conn = null;
	private Connection dbconnection = null;
	
	public static ConnectionFactory getInstance() {
		if (conn == null) {
			conn = new ConnectionFactory();
		}
		return conn;
	}
	
	public Connection getConnection() throws Exception {
		//if (dbconnection == null) {
			try {
				System.out.println("Connection Init");
				// 	Obtain our environment naming context
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				// Look up our data source
				DataSource ds = (DataSource) envCtx.lookup("jdbc/TBOK");
				// Allocate and use a connection from the pool
				dbconnection = ds.getConnection(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
		
		return dbconnection;
		//return (Connection) DriverManager.getConnection(url, user, password);
	}

}
