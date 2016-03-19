
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ColorGetServletWithHtmlFile")
public class ColorGetServletWithHtmlFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ColorGetServletWithHtmlFile() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("Served at: ").append(request.getContextPath());
		pw.append("\nUsed Method doGet()");
		String color = request.getParameter("color");
		response.setContentType("text/html");
		pw.println("\n<B>The selected color is: ");
		pw.println(color);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
