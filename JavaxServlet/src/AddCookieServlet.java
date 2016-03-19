import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// получить параметр из НТТР-запроса
		String data = request.getParameter("data");
		// создать сооkiе-файл
		Cookie cookie = new Cookie("MyCookie", data);
		cookie.setMaxAge(60*24*31);
		// ввести сооkiе-файл в НТТР-ответ
		response.addCookie(cookie);
		// вывести результат в окне браузера
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<B>MyCookie has been set to ");
		pw.println(data);
		pw.close();
	}
}