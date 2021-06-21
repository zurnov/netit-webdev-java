import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProcessor extends HttpServlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy form processor");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Create form processor");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service специализиран за GET заявки
	}
	
	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		String name = arg0.getParameter("user_name");
		int age = Integer.parseInt(arg0.getParameter("user_age"));
		String redirect = "error.jsp";
		
		boolean isBace = name.equals("Boiko") && age == 61;
		
		if(isBace) {
			redirect = "succsess.jsp";
		}
		arg1.sendRedirect(redirect);
		}
		catch(Exception e){
			arg1.sendRedirect("index.jsp");
		}
	}

}
