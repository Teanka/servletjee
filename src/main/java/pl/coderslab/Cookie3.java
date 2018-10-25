package pl.coderslab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3",urlPatterns = "/Cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String time = request.getParameter("select");
//też if name nie puste i
        Cookie cookie = new Cookie(key,value);
        if(time!=null&&!time.isEmpty()){
            try{
                int timeInt = Integer.parseInt(time);
                timeInt*=3600;
                cookie.setMaxAge(timeInt);
            } catch(NumberFormatException e){
                response.getWriter().append("select nie był liczbą");
            }
        } else {
            response.getWriter().append("select był nullem");
        }
        response.addCookie(cookie);
        response.getWriter().append("ciastko o kluczy " +key+" i wartości "+ value+ " gotowe!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index_33.html");
        dispatcher.forward(request,response);
    }
//    W projekcie stwórz servlet Cookie3 oraz stronę HTML index_3.html, strona ma zawierać formularz z polami jak w zadaniu 2, oraz dodatkowym polem select,
//    z wartościami od 1 - 10. Po zatwierdzeniu formularza zostanie dodane ciasteczko o podanej nazwie, wartości i czasem życia w godzinach, pobranym z pola formularza typu select.
//
//            Hint: Żeby sprawdzić czy ciasteczko jest poprawnie zapisane, przejdź do konsoli deweloperskiej Twojej przeglądarki (ctrl + shift + i),
//    następnie do zakładki Application lub storage -mozilla i wybierz Cookies z tabelki po prawej stronie. Powinny Ci się wtedy wyświetlić wszystkie ciasteczka jakie są trzymane w Twojej przeglądarce.
}
