package com.xoa.util;  
  
import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.ResultSet;
import java.sql.Statement;

  
public class CheckTableExist {  
	
	
	public static boolean haveTable(String tableName){
		  Connection connection = null;  
	        try {  
	            String userName = "root";  
	            String password = "gaosubo3000";  
	            String jdbcurl = "jdbc:mysql://192.168.0.21:3306/xoa1001?useUnicode=true&characterEncoding=utf-8";  
	            Class.forName("com.mysql.jdbc.Driver").newInstance();  
	            connection = DriverManager.getConnection(jdbcurl, userName,  
	                    password);  
	            DatabaseMetaData md = connection.getMetaData();  
	            //String tableName = "staff";  
	            //String columnName = "column_name";  
	            ResultSet rs = md.getTables(null, null, tableName, null);  
	            if (rs.next()) {  
	                System.out.println("Table " + tableName + " exist");  
	                return true;	         
	            } else {  
	                System.out.println("Table " + tableName + " not exist");  
	                return false;
	            }  
	        } catch (Exception e) {  
	            System.err.println("Cannot connect to database server,Exception:"  
	                    + e.getMessage());  
	        } finally {  
	            if (connection != null) {  
	                try {  
	                    connection.close();  
	                    connection = null;  
	                } catch (Exception e) { /* ignore close errors */  
	                }  
	            }  
	        }
			return false;  
	}
	
	
	 public static boolean createSql(String sql) {  
	        Connection connection = null;  
	        try {  
	            String userName = "root";  
	            String password = "gaosubo3000";  
	            String jdbcurl = "jdbc:mysql://192.168.0.21:3306/xoa1001?useUnicode=true&characterEncoding=utf-8";  
	            Class.forName("com.mysql.jdbc.Driver").newInstance();  
	            connection = DriverManager.getConnection(jdbcurl, userName,  
	                    password); 
	             //第三步：建立一个statement的对象
	            Statement st = connection.createStatement();
 
	            ResultSet rs=st.executeQuery(sql);                  
	            while(rs.next()){  
	            	return true;
	            }
	        } catch (Exception e) {  
	            System.err.println("Cannot connect to database server,Exception:"  
	                    + e.getMessage());  
	        } finally {  
	            if (connection != null) {  
	                try {  
	                    connection.close();  
	                    connection = null;  
	                } catch (Exception e) {
	                }  
	            }  
	        }
			return false;  
	    }  
	
	
	
  
    public static void main(String[] args) {  
        Connection connection = null;  
        try {  
            String userName = "root";  
            String password = "111111";  
            String jdbcurl = "jdbc:mysql://192.168.0.21:3306/xoa1001?useUnicode=true&characterEncoding=utf-8";  
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            connection = DriverManager.getConnection(jdbcurl, userName,  
                    password);  
            DatabaseMetaData md = connection.getMetaData();  
            String tableName = "staff";  
            String columnName = "column_name";  
            ResultSet rs = md.getTables(null, null, tableName, null);  
            if (rs.next()) {  
                System.out.println("Table " + tableName + " exist");  
                rs = md.getColumns(null, null, tableName, columnName);  
                if (rs.next()) {  
                    System.out.println("Table " + tableName  
                            + " exist in Table " + tableName);  
                } else {  
                    System.out.println("Column " + tableName  
                            + " not exist in Table " + tableName);  
                }  
            } else {  
                System.out.println("Table " + tableName + " not exist");  
            }  
        } catch (Exception e) {  
            System.err.println("Cannot connect to database server,Exception:"  
                    + e.getMessage());  
        } finally {  
            if (connection != null) {  
                try {  
                    connection.close();  
                    connection = null;  
                } catch (Exception e) { /* ignore close errors */  
                }  
            }  
        }  
    }  
}  
  