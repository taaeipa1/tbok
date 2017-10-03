package org.istqb.test;

import java.sql.Connection;

import org.istqb.util.ConnectionFactory;

public class TestConnectionFactory {
	
	public static void main(String[] args) throws Exception {
		Connection con = null;
		try {
			con = ConnectionFactory.getInstance().getConnection();
			System.out.println("Connection successful");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con !=null) {
					con.close();
					System.out.println("Connection closed");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}