package pl.coderslab;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get1", urlPatterns = "/Get1")
public class Get1 extends HttpServlet {
    private static final org.apache.log4j.Logger log = Logger.getLogger(Get1.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        log.info("Start: " + start + "end: " + end);
        if (start != null && !start.isEmpty() && end != null && !end.isEmpty()) {
            try {
                int startValue = Integer.parseInt(start);
                int endValue = Integer.parseInt(end);
                if (startValue <= endValue) {
                    response.getWriter().append("<h2>start: ")
                            .append(start)
                            .append(" /<h2>")
                            .append("<br>")
                            .append("<h2>End: ")
                            .append(end)
                            .append("</h2><br>")
                            .append("<ul>");
                    for (int i = startValue; i <= endValue; i++) {
                        response.getWriter().append("<li>")
                                .append(String.valueOf(i))
                                .append("</li>");
                    }
                    response.getWriter().append("</ul>");
                }
            } catch (NumberFormatException e) {
                response.getWriter().append("<h1>Dane wejściowe nieprawidłowe</h1>");
            }
            //obróbka danych wejściowych
        } else {
            response.getWriter().append("<h1>Brak danych wejściowych</h1>");
        }
    }
    //do przeglądarki wpisać np http://localhost:8080/Get1?start=1&end=10
}
