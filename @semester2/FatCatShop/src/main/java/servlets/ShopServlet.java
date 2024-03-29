package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String isGreated 	 = (String) req.getSession().getAttribute("is_greeted");
		boolean isAccessable = isGreated != null && isGreated.equals("Y");
				
		if(!isAccessable) {
			resp.sendRedirect("401.jsp");
			return;
		}
		
		String gender 	= (String) req.getSession().getAttribute("user_gender");
		String name 	= (String) req.getSession().getAttribute("user_name");
		//String age 	= req.getSession().getAttribute("user_age");
		
		String age 	= String.valueOf(req.getSession().getAttribute("user_age"));
		String official = "";
		
		if(gender.equals("male")) {
			official = "Mr . " + name;
		}
		
		if(gender.equals("fimale")) {
			official = "Miss . " + name;
		}		
		
		req.setAttribute("user_name", official);
		if(name.equals("azis") && age.equals("43")) { 
			req.getRequestDispatcher("azisSecretPath.jsp").forward(req, resp);
		}
		else {
		req.getRequestDispatcher("shop.jsp").forward(req, resp);
		}
	}
}