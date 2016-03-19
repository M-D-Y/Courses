import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostParametersServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// получить поток записи типа PrintWriter
		PrintWriter rpw = response.getWriter();
		rpw.append(getClass() + "\nServed at: ").append(request.getServletContext().getContextPath());
		rpw.append("\n\nParameters:\n");
		// получить перечисление имен параметров
		Enumeration e = request.getParameterNames();
		// вывести имена параметров и их значения
		while (e.hasMoreElements()) {
			String pname = (String) e.nextElement();
			rpw.print(pname + "=");
			String pvalue = request.getParameter(pname);
			rpw.println(pvalue);
		}
		rpw.close();
	}
		
}