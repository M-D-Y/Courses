package net.codejava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WithoutWebXMLServlet")
public class WithoutWebXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WithoutWebXMLServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("Without web.xml Servlet\n");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
