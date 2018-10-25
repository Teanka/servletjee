package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get63",urlPatterns = "/Get63")
public class Get63 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String year = request.getParameter("year");
        String mix = request.getParameter("mix");
        if(year!=null&&!year.isEmpty()&&mix!=null&&!mix.isEmpty()){
            try {
                int yearInt = Integer.parseInt(year);
                int mixInt = Integer.parseInt(mix);
                response.getWriter().append("Rok to: " + (yearInt+mixInt));

            }catch(NumberFormatException e){
                response.getWriter().append("mix or year are not number values");
            }
        } else{
            response.getWriter().append("Got a null as input");
        }
    }

}
