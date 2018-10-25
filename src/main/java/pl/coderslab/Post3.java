package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post3",urlPatterns = "/Post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String aa = request.getParameter("a");
        String bb = request.getParameter("b");
        String cc = request.getParameter("c");
        if(aa!=null&&!aa.isEmpty()&&bb!=null&&!bb.isEmpty()&&cc!=null&&!cc.isEmpty()){
            try{
                double a = Double.parseDouble(aa);
                double b = Double.parseDouble(bb);
                double c = Double.parseDouble(cc);
                double delta = b*b - 4*a*c;
                if(delta>0){
                    double delta1 = Math.sqrt(delta);
                    double x1 = (-b - delta1)/(2*a);
                    double x2 = (-b + delta1)/(2*a);
                    response.getWriter().append("Są dwa pierwiastki równania:  x1 = " +x1 + " i x2 = " +x2);
                    //np 1,1, -2
                } else if(delta==0){
                    double x0 = -b/(2*a);
                    response.getWriter().append("Jest jeden pierwiastek równania x0 = " +x0);
                    //np 4,4 1 odp -0.5
                } else {
                    response.getWriter().append("Brak pierwiastków równania.");
                }


            }catch (NumberFormatException e){
                response.getWriter().append("Podane parametry są nieprawidłowe.");
            }

        } else {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    W projekcie stwórz servlet Post3 oraz stronę HTML index_3.html. Następnie:
//
//    Napisz formularz, zawierający trzy pola liczbowe: a, b i c.
//    Dopisz funkcjonalność, która po przesłaniu formularza wyliczy miejsca zerowe funkcji kwadratowej zdefiniowanej poprzez podane w formularzu liczby (ax^2+bx+c).
//    Wyświetl wyliczone miejsca zerowe na stronie. W przypadku delta<0 servlet wyświetli odpowiedni komunikat.

}
