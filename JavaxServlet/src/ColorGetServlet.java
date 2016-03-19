
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.CharBuffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ColorGetServlet
 */
@WebServlet("/ColorGetServlet")
public class ColorGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ColorGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("\nUsed method: service()");
		// String htmlFile =
		// getClass().getClassLoader().getResource("GetColor.html").getFile();
		// System.out.println("Path: " + htmlFile);
		// File f = new File(htmlFile);
		// FileReader reader = new FileReader(f);
		// char[] buffer = new char[(int) f.length()];
		// // считаем файл полностью
		// reader.read(buffer);
		// response.getWriter().println(buffer.toString());
		// System.out.println(buffer.toString());
		// reader.close();

		StringBuilder htmlText = new StringBuilder();
		htmlText.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>ColorGetServlet</title>");
		htmlText.append("</head><body><center>");

		htmlText.append("<form name=\"Forml\" method=\"get\" action=\"http://localhost:8080/JavaxServlet/ColorGetServlet\">");
		
		htmlText.append("Served at: " + request.getContextPath() +"<br>");
		htmlText.append("<br>Used method: service()<br><br>");
		
		htmlText.append("<B>Please select Color: </B><select name=\"color\"size=\"l\"><option value=\"Red\">Red</option>");
		htmlText.append("<option value=\"Green\">Green</option><option value=\"Blue\">Blue</option>");
		htmlText.append("</select><br><br><input type=submit value=\"Submit\">");
		if (request.getParameterNames().hasMoreElements()) {
			String color = request.getParameter("color");
			response.setContentType("text/html");
			htmlText.append("<br><br><B>The selected color is: ");
			htmlText.append(color);
		}
		htmlText.append("</form></body></html>");
		response.setContentType("text/html");
		
		response.getWriter().append(htmlText.toString());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.append("Served at: ").append(request.getContextPath());
		pw.append("\nUsed Method doGet()");
		String color = request.getParameter("color");
		response.setContentType("text/html");
		pw.println("<B>The selected color is: ");
		pw.println(color);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
