//package com.cpc.db.enhancements;
package com.cisco.cpc.util;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CPCImage {//
	
	private static final String dev_db_url = "jdbc:oracle:thin:@ldap://ldap-ldprd.cisco.com:5000/cn=OracleContext,dc=cisco,dc=com/MKWBDEV";
	private static final String stage_db_url = "jdbc:oracle:thin:@ldap://ldap-ldprd.cisco.com:5000/cn=OracleContext,dc=cisco,dc=com/MKWBSTG";
	private static final String prod_db_url = "jdbc:oracle:thin:@ldap://ldap-ldprd.cisco.com:5000/cn=OracleContext,dc=cisco,dc=com/MKWBPRD";
	private static final String imageName = "C:\\Users\\saisura\\Downloads\\C1121X-8PLTEPW_.png";//"C:\\ciscophattale\\Projects\\cpc_documents\\C9300_C9200\\9th Aug 2022 - Manish Sharma\\C9200CX-12P-2X2G_Front-Straight_3423.png";//"C:\\ciscophattale\\Projects\\cpc_documents\\C9300\\20_Jan_2022\\C9300X-48HX+NM-4C_Front.png";//\\C9300X-48HXN+NM-2C_Front.png";//\\C9300X-24HX+NM-8Y_Front.png";
	public static void main(String args[]) throws Exception{
	      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver ());
	      String oracleUrl = stage_db_url;
	      Connection con = DriverManager.getConnection(oracleUrl, "cpc_admin", "cpc_admin");
	      System.out.println("Connected to Oracle database.....");
	      //PreparedStatement pstmt = con.prepareStatement("update cpc_master_platform set PLATFORM_IMAGE = ? where platform_id = 176");
	     // PreparedStatement pstmt = con.prepareStatement("update cpc_master_platform set PLATFORM_IMAGE = ? where platform_id = 177");
	      PreparedStatement pstmt = con.prepareStatement("update cpc_master_platform set PLATFORM_IMAGE = ? where platform_id = 245");
	     // PreparedStatement pstmt = con.prepareStatement("update CPC_MASTER_CHASSIS_SLOTS set CHASSIS_IMAGE = ? where chassis_id = 55");
	      InputStream in = new FileInputStream(imageName);
	      pstmt.setBlob(1, in);
	      pstmt.execute();
	      con.close();
	      System.out.println("Record inserted");
	   }
}
