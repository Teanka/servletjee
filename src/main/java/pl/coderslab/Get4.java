package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get4", urlPatterns = "/Get4")
public class Get4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("input/text; charset=utf-8");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
//        response.getWriter().append(" <form method=\"post\" action=\"\">\n" +//akcja gdzie wysłać, a wczyta się index.html nawet jak nie ma servletu.
//                "        <input type=\"number\" placeholder=\"Podaj wartosc\" name=\"page\" />\n" +
//                "        <input type=\"submit\" value=\"Wyślij\" />\n" +
//                "    </form>");
        String page = request.getParameter("page");
        if(page!= null&&!page.isEmpty()){
            response.getWriter().append(page);

        try {
            int param = Integer.parseInt(page);
            response.getWriter().append("wartość została przesłana, dzielniki podanej liczby to:");
            for(int i =1; i<=param; i++){
                if((param%i==0)){
                    response.getWriter().append(i+ " ,");
                }
            }
        } catch (NumberFormatException e){
            response.getWriter().append("Zły numer");
        }
        } else{
//            response.getWriter("Brak parametru");
        }
    }
//    Zadanie 4
//
//    W projekcie stwórz servlet Get4, dostępny pod adresem /Get4, oraz stronę HTML index.html, w której zawarty jest formularz przesyłany metodą GET z jednym polem page.
//    Po uruchomieniu aplikacji na serwerze, uzupełnieniu i zatwierdzeniu formularza w przeglądarce wyświetli się informacja czy wartość została przesłana oraz wyświetlone
//    zostaną dzielniki całkowite przesłanej liczby.
}
