package database;

import java.util.Properties;

public class DatabaseConfig {
	
	public static final String DRIVER 	= "mysql";
	public static final String PORT 	= "3306";
	public static final String SCHEMA 	= "javadb";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	
	public static String getUrl() {
		return "jdbc:"			+
				DRIVER 			+ 
				"://localhost:" +
				PORT 			+
				"/" 			+
				SCHEMA;
	}
	public static Properties getCredentials() {
		Properties credentials = new java.util.Properties();

        if (USERNAME != null) credentials.put("user", USERNAME);  
        if (PASSWORD != null) credentials.put("password", PASSWORD);
        
        return credentials;
	}
}
