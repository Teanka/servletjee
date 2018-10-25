package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get61",urlPatterns = "/Get61")
public class Get61 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int min = 1980;
        int max = 2010;
        for(int i =min; i<=max;i++){
            response.getWriter().append("<a href = \"http://localhost:8080/Get62?year=" + i +" \">"+"link do roku " + i +"</a> <br>");
        }

    }
    //    Pierwszy Get61, powinien generować linki do drugiego Get62, przekazując metodą GET dane pod kluczem year (od 1980 do 2010).
}
