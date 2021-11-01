package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.*;

public class Database {

	private Connection connection;
	
	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			this.connection = DriverManager.getConnection(
					DatabaseConfig.getUrl(),DatabaseConfig.getCredentials());
		}
			catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	public void insert(String table, String[] into, String[] values) {
		
		String intoColumnString = "";
		for(String element : into) {
			intoColumnString += (element + ",");
		}
		intoColumnString = 	"(" +
		intoColumnString.substring(0, intoColumnString.length() - 1)
							+ ")";
		
		
		
		String valuesColumnString = "";
		for(String element : values) {
			valuesColumnString += (element + ",");
		}
		valuesColumnString = "(" + valuesColumnString.substring(0, valuesColumnString.length() - 1) + ")";
		
		String query = "INSERT INTO " 		+
						table 				+
						intoColumnString	+
						"VALUES" 			+
						valuesColumnString;
		
		try {
			Statement queryManager = this.connection.createStatement();
			queryManager.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String table,HashMap<String, String> relation) {
		
		String[] intoCollection = (String[]) relation.keySet().toArray(new String[0]);
		String[] valueCollection = (String[]) relation.values().toArray(new String[0]);
		this.insert(table, intoCollection,valueCollection);
	}
	public void update(String table, String[] column, String[] value) {

		// провери дали дължината на колоните съвпада с дължината на стойностите
		// ако не съвпада имаме проблем
		
		String updateSet = "";
		for(int i = 0; i < column.length; i++) {
			updateSet += column[i] + " = " + value[i] + ",";
		}
		updateSet = updateSet.substring(0, updateSet.length() - 1);
		
		String query = "UPDATE " + table  + " SET "+ updateSet; 
		this.executeQuery(query);
		// UPDATE {table} 
		// SET {key} = {value}
		// WHERE {col_name} [operator] {value}
	}
	public void update(String table, HashMap<String, String> relation) {

		String[] columnCollection  = relation.keySet().toArray(new String[0]);
		String[] valueCollection = relation.values().toArray(new String[0]);
		this.update(table, columnCollection, valueCollection);
	}
	public void delete() {
		
	}
	public ResultSet select(String table) {
		
		String query = "SELECT * FROM " + table;
      
		try {
			Statement queryManager = this.connection.createStatement();
			return queryManager.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	private void executeQuery(String query) {

		try {
			Statement queryManager = this.connection.createStatement();
			queryManager.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private ResultSet fetchQuery(String query) {
			
			try {
				Statement queryManager = this.connection.createStatement();
				return queryManager.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	
}