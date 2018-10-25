package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie4Del",urlPatterns = "/Cookie4Del")
public class Cookie4Del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0){
            boolean found=false;
            for (Cookie cookie:cookies){
                if(cookie.getName().equals(name)){
                    found=true;
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    response.getWriter().append("Usunelam ciasteczko");
                }
            }
            if(!found){
                response.getWriter().append("Nie znaleziono ciasteczka ");
            }
        }else{

            response.getWriter().append("Nie znaleziono ciasteczka ");
        }
    }
}
