package pl.coderslab;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get3", urlPatterns = "/Get3")
public class Get3 extends HttpServlet {
    private static final org.apache.log4j.Logger log = Logger.getLogger(Get3.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        int width=5;
        int height=10;

        String widthParam = request.getParameter("width");
        String heightParam = request.getParameter("height");

        try {
            width = widthParam == null || widthParam.isEmpty() ? 5 : Integer.parseInt(widthParam);
            height = heightParam == null || heightParam.isEmpty() ? 10 : Integer.parseInt(heightParam);
        }catch (NumberFormatException e){ e.printStackTrace();

        }
        PrintWriter writer = response.getWriter();
        writer.append("<table><thead></thead><tbody>");
        for (int i = 1; i <= width; i++) {
            writer.append("<tr>");
            for (int j = 1; j <= height; j++) {
                writer.append("<td style='border:solid #e3e3e3 1px;'>");
                writer.append("" + i +" * "+ j)
                        .append(" = ")
                        .append(String.valueOf(i * j));
                writer.append("</td>");
            }
            writer.append("</tr>");
        }
        writer.append("</tbody></table>");
//        PrintWriter posiada również metodę println – analogiczną do znanego nam już System.out.println(). Np.:
//
//        PrintWriter writer = response.getWriter();
//        writer.println("test text");


    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String width = request.getParameter("width");
//        String height = request.getParameter("height");
//        int widthInt = 5;
//        int heightInt = 10;
//        log.info("width: " + width + " height " + height);
//        if (width != null && !width.isEmpty() && height != null && !height.isEmpty()) {
//            try {
//                int widthtemp = Integer.parseInt(width);
//                int heighttemp = Integer.parseInt(height);
//                if (widthtemp > 0 && widthtemp<20 && heighttemp > 0 &&heighttemp<20) {
//                    widthInt = widthtemp;
//                    heightInt = heighttemp;
////                    response.getWriter().append("<h2>start: ")
////                            .append(width)
////                            .append(" /<h2>")
////                            .append("<br>")
////                            .append("<h2>End: ")
////                            .append(height)
////                            .append("</h2><br>")
////                            .append("<ul>");
//                }
//            } catch (NumberFormatException e) {
//                response.getWriter().append("<h1>Dane  wejściowe nieprawidłowe, zastąpione wartościamu defaultowymi.</h1>");
//            }
//            //obróbka danych wejściowych
//        } else {
//            response.getWriter().append("<h1>Brak danych wejściowych,  użyto  wartości defaultowych.</h1>");
//        }
////        PrintWriter printWriter = new PrintWriter()
//        response.getWriter().append("<table> <thead> </thead> <tbody>");
//        widthInt=5;
//        heightInt=10;
//        for (int i = 1; i <= widthInt; i++) {
//            response.getWriter().append("<tr>");
//            for (int j = 1; i <= heightInt; j++) {
//                response.getWriter().append("<td> " + i + " * " + j + " = " + i * j + "</td>");
//            }
//            response.getWriter().append("</tr>");
//        }
//        response.getWriter().append("</tbody></table>");
//    }


}
//do przeglądarki wpisać np http://localhost:8080/Get1?start=1&end=10


//    W projekcie stwórz servlet Get3, który ma pobierać dwie zmienne o nazwach width i height.
//    Jeżeli informacje nie są przesłane to width = 5 i height = 10.
//    Następnie wygeneruj tabliczkę mnożenia o podanej wysokości i szerokości i wyświetl ją w przeglądarce.


