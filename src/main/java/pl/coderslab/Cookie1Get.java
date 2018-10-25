package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Cookie1Get", urlPatterns = "/showCookie")
public class Cookie1Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0){
            boolean found=false;
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("User")){
                    found=true;
                    response.getWriter().append("Moje ciasteczko to: "+cookie.getValue()+" a maxAge to: "+cookie.getMaxAge());
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
