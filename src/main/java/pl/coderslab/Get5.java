package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get5", urlPatterns = "/Get5")
public class Get5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        //nie znam liczby ani wartości, klucze i wartości albo get parameter names i get par values i jeszcze get parameter map
        Map<String,String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for(String key: keys){
            String[] values = map.get(key);
            response.getWriter().append("<p>").append("<ul>");
            for(String value: values){
                response.getWriter().append("<li>")
                        .append(value)
                        .append("</li>");
            }
            response.getWriter().append("</ul>");
        }

    }
}
