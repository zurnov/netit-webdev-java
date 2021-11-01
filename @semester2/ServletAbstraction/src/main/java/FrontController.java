import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/*")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp
			) throws ServletException, IOException {
			
			String requestUrl = req.getPathInfo();
			String[] urlSegmentCollection = requestUrl.split("/");
			String controllerSegment	=urlSegmentCollection[1];
			String requestController = 		controllerSegment;
			String requestMethod = 			urlSegmentCollection[2];
			
			//Load request controller class
			try {
				Class<?> classReference = Class.forName(requestController);
				Method classReferenceMethod = classReference.getMethod(requestMethod, null);
				
				Object controllerInstance	= classReference.getConstructor().newInstance();
				
				classReferenceMethod.invoke(controllerInstance);
				
				
				
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
