package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "Post2", urlPatterns = "/Post2")
public class Post2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String accept = request.getParameter("accept");
        response.setContentType("text/html; charset=utf-8");
        if(text!=null && !text.isEmpty()){
            if(accept==null){
                accept = "off";
            }
            if(!accept.equals("on")) {
                text = checkWords(text);
            }
            response.getWriter().append("<p>").append(text).append("</p>");
        }
        response.getWriter().append(text).append(" | ").append(accept);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Jestem w doGet a chyba nie powinienem???!");
    }

    private String checkWords(String text){
        StringBuilder checkedText = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            boolean foundBadWord = false;
            for(String w:badWords){
                if(w.contains(token.toLowerCase())){
                    foundBadWord = true;
                    break;
                }
            }
            if(foundBadWord){
                String tmp = "";
                for(int i=0;i<token.length();i++){
                    tmp+="*";
                }
                checkedText.append(tmp);
            }else{
                checkedText.append(token);
            }
            checkedText.append(" ");
        }
        return checkedText.toString();
    }
    private static String[] badWords = {"cholera","kurde","kurła"};
}
