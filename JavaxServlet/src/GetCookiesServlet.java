import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GetCookiesServlet")
public class GetCookiesServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// получить сооkiе-файлы из заголовка НТТР-запроса
		Cookie[] cookies = request.getCookies();
		// вывести все сооkiе-файлы
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<B>");
		for (int i = 0; i < cookies.length; i++) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			pw.println("name = " + name + ", value = " + value);
		}
		pw.close();
	}
}