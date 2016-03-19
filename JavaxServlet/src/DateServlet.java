import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// получить объект типа HttpSession
		HttpSession hs = request.getSession(true);
		response.setContentType("text/html");
		// получить поток записи типа PrintWriter
		PrintWriter pw = response.getWriter();
		pw.print("<B>");
		// вывести дату и время последнего доступа к странице
		Date date = (Date) hs.getAttribute("date");
		if (date != null) {
			pw.print("Last access: " + date + "<br>");
			// вывести текущие дату и время
		}
		date = new Date();
		hs.setAttribute("date", date);
		pw.println("Current date: " + date);

	}
}