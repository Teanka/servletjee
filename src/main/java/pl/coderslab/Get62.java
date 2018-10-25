package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Get62",urlPatterns = "/Get62")
public class Get62 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String year = request.getParameter("year");
        Random random = new Random();
        int mix;
        if(year!=null&&!year.isEmpty()){
            try{
                int yearInt = Integer.parseInt(year);
                for(int i =0; i<=5;i++){
                    mix = random.nextInt(21)-10;

                    response.getWriter().append("<a href = \"http://localhost:8080/Get63?year=" + yearInt +"&mix="+mix+ " \">"+"Rok: " + yearInt + " Mix: " +mix+"</a> <br>");
                    yearInt++;
                }
            }catch (NumberFormatException e){
                response.getWriter().append("Not a proper year number");
            }

        } else{
            response.getWriter().append("Didn't get response.");
        }
    }
//    Drugi Get62 powinien odebrać przesłane poprzez GET dane z pierwszego Get61 i wygenerować 5 linków,
//    gdzie każdy z nich ma przenosić do trzeciego Get63 przekazując metodą GET następujące dane:
//    year - dane przesłane z poprzedniej strony
//    mix - losowa wartość z zakresu od -10 do 10

}
