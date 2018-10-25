package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get4_test", urlPatterns = "/Get4_test")
public class Get4_test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append("Formularz przeniosl mnie do POSTA")
                .append("Parametr: ").append(request.getParameter("param"));
        //2
//        response.sendRedirect("/Get4_test");   //tu przechodzimy z posta do geta.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append("JESTEM W doGet");
        response.getWriter().append(" <form method=\"post\" action=\"\">\n" + // jest puste bo chcemy żeby wysało na ten sam adres, tylko do metody post
                "        <input type=\"text\" placeholder=\"Podaj wartosc\" name=\"param\" />\n" + //tu jest param
                "        <input type=\"submit\" value=\"Wyślij\" />\n" +
                "    </form>");
        //1
//        <form method="get" action="/Get4">
//        <input type="number" placeholder="Podaj wartosc" name="page" value="100" />
//        <input type="submit" name="xxx" value="Wyślij" />
//    </form>
    }



//

}
