package pl.coderslab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2",urlPatterns = "/addToCookie")
public class Cookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        response.getWriter().append("ciastko o kluczy " +key+" i wartości "+ value+ " gotowe!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index2.html");
        dispatcher.forward(request,response);
    }
}
