package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie4Show", urlPatterns = "/Cookie4Show")
public class Cookie4Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                response.getWriter().append("Moje ciasteczko to: nazwa " + cookie.getName() + " wartość " + cookie.getValue() + " a maxAge to: " + cookie.getMaxAge());
                response.getWriter().append("<a href = \"http://localhost:8080/Cookie4Del?name=" + cookie.getName() + " \">" + cookie.getName() + "</a> <br>");
            }

        } else {

            response.getWriter().append("<p>Nie znaleziono ciasteczka</p> ");
        }
    }
//    W projekcie stwórz servlet Cookie4Show i Cookie4Del. Następnie:
//
//    W servlecie Cookie4Show wyświetl wszystkie ciasteczka.
//    Przy każdym z nich wygeneruj link do drugiego servletu Cookie4Del. Pamiętaj o przekazaniu w danych GET nazwy tego ciasteczka.
}
