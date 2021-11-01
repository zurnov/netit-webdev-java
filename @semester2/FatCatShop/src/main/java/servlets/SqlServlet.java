package servlets;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Driver;

import database.Database;
public class SqlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Database db				= new Database();
		ResultSet collection 	= db.select("users");
		
		try {
			while(collection.next()) {
				System.out.print(collection.getString("first_name"));
				System.out.print(collection.getString("last_name"));
				System.out.println("*");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] columns = {
				"first_name","last_name"
		};
		String[] values = {
				"'Shasho'", "'Roman'"
		};
		HashMap<String,String> relation = new HashMap<>();
		relation.put("first_name", "'Grigori'");
		relation.put("last_name", "'Emilov'");
		
		HashMap<String,String> shorthand = new HashMap<>() {{
		
		put("first_name", "'Test'");
		put("last_name", "'Testis'");
		}};
		
		db.insert("users", relation);
		db.insert("users", shorthand);
		
	}

}
