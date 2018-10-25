package pl.coderslab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("convertionType");
        String degrees = request.getParameter("degrees");
        response.setContentType("text/html;charset=utf-8");
        try {
            double value = Double.valueOf(degrees);
            if(type!=null && type.equals("celcToFahr")) {
                double f = value * 9.0 / 5.0 + 32.0;
                response.getWriter().append("<h2>Stopnie Celcjusza: "+degrees+" to "+String.format("%.2f",f)+" stopni Farenheita");
            }else if(type!=null && type.equals("FahrToCelc")) {
                double c = (value - 32.0) * 5.0 / 9.0;
                response.getWriter().append("<h2>Stopnie Farenheita: "+degrees+" to "+String.format("%.2f",c)+" stopni Celcjusza");
            }else{
                response.getWriter().append("<h2>Nieprawidłowy typ</h2>");
            }
        }catch (NumberFormatException e){
            response.getWriter().append("<h2>MUSISZ PODAC wartość jako liczbę</h2>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("index_5.html");
        dispatcher.forward(request,response);
    }

}
