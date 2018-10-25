package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
@WebServlet("/Post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Map<String, String[]> map = request.getParameterMap();
//        String[] tab = map.get("numbers");
        String[] tab = request.getParameterValues("numbers");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String str: tab){
            try {
                int tmp = Integer.parseInt(str);
                numbers.add(tmp);
            }catch (NumberFormatException e){

            }
        }
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.intValue()-o1.intValue();
//            }
//        };
//        numbers.sort(comparator);
        Collections.sort(numbers);
        response.setContentType("text/html;charset=utf-8");
        for (Integer i: numbers){
            response.getWriter().append(""+i+"<br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.append("<form action='' method='post'>");
        Random random = new Random();
        int max = random.nextInt(6)+5;

        for(int i=0;i<max;i++) {
            writer.append(" <input type='number' name='numbers' placeholder='podaj wartosc'/><br/>");
        }

        writer.append("<input type='submit' value='Wyslij'/>");
        writer.append("</form>");
    }

}
//@WebServlet(name = "Post4", urlPatterns = "/Post4")
//public class Post4 extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=utf-8");
//        String[] keys = request.getParameterValues("numbers");
//        if (keys == null || keys.length == 0) {
//            response.getWriter().append("No data sent!");
//        } else {
//            int[] arr = new int[0];
//            for (String key : keys) {
//                if (key != null) {
//                    try {
//                        int intValue = Integer.parseInt(key);
//                        int[] temp = new int[arr.length + 1];
//                        temp[temp.length - 1] = intValue;
//                        arr = temp;
//                    } catch (NumberFormatException e) {
//                        response.getWriter().append(key);
//                    }
//                }
//            }
//            Arrays.sort(arr);
//            response.getWriter().append("<table><thead></thead><tbody><tr>");
//            for (int j = 0; j < arr.length - 1; j++) {
//                response.getWriter().append("<td>" + arr[j] + "</td>");
//            }
//
//            response.getWriter().append("</tr></tbody></table>");
//
//
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");//po to żeby get wstrzyknąć do geta stronkę i ją odpalić jako response.
//        response.setContentType("utf-8");
////        request.getRequestDispatcher("/index_2.html").forward(request,response);
////        response.setContentType("text/html; charset=utf-8");
//        response.getWriter().append("<form action='' method='post'>").append("<br> ");
//        Random random = new Random();
//        int randInt = random.nextInt(16) - 5;
//        for (int i = 0; i < randInt; i++) {
//            response.getWriter().append("<input name=\"numbers\"/><br/>");
//        }
//
//        response.getWriter().append("<input type='submit'/></form>");
//    }
//    W projekcie stwórz servlet Post4. Następnie:
//
//    w metodzie doGet, będzie wyświetlał formularz z losową ilością parametrów (w zakresie od 5 do 10) o takiej samej nazwie numbers.
//    W metodzie doPost pobierz wszystkie parametry - te z nich, które reprezentują wartość liczbową, wyświetl posortowane od najmniejszego do największego.

//    <form action='' method='post'>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//<input name='numbers'/><br/>
//
//<!-- parametrów może być więcej  -->
//
//<input type='submit'/>
//</form>

