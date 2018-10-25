package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Get2", urlPatterns = "/Get2")
public class Get2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //localhost:8080/Get2?key=param1&key=param2&key1=xyz&key_nowy=55&key=cokolwiek
        Enumeration<String> stringEnumeration = request.getParameterNames();   //enumeration działa trochę jak iterator działa póki coś ma w środku// można było mapę ale wtedy tylko gdy użytkownik podaje klucz ma wartość etc.
        while(stringEnumeration.hasMoreElements()){
            String key = stringEnumeration.nextElement();
            String[] values = request.getParameterValues(key);
            response.getWriter().append("<h2>Key: ").append(key).append("</h2>").append("<ul>");
            for(String value:values){
                response.getWriter().append("<li>").append(value).append("</li>");
            }
            response.getWriter().append("</ul>");
        }
    }
// W projekcie stwórz servlet Get2, który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość (niezależnie od liczby przesłanych parametrów).
}
