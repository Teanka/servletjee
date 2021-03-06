package pl.coderslab;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "Servlet16",urlPatterns = "/Servlet16")
public class Servlet16 extends HttpServlet {
    private static final org.apache.log4j.Logger log = Logger.getLogger(Servlet16.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getDateHeader(LocalDate.now().toString());
        String browser = request.getHeader("User-Agent");//wiele możliwych
        String browser1 = "";
        if (browser.contains("msie"))
        {
        String substring=browser.substring(browser.indexOf("MSIE")).split(";")[0];
        browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else if (browser.contains("safari") && browser.contains("version"))
        {
        browser=(browser.substring(browser.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(browser.substring(browser.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if ( browser.contains("opr") || browser.contains("opera"))
        {
        if(browser.contains("opera"))
        browser=(browser.substring(browser.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(browser.substring(browser.indexOf("Version")).split(" ")[0]).split("/")[1];
        else if(browser.contains("opr"))
        browser=((browser.substring(browser.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        } else if (browser.contains("chrome"))
        {
        browser=(browser.substring(browser.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((browser.indexOf("mozilla/7.0") > -1) || (browser.indexOf("netscape6") != -1)  || (browser.indexOf("mozilla/4.7") != -1) || (browser.indexOf("mozilla/4.78") != -1) || (browser.indexOf("mozilla/4.08") != -1) || (browser.indexOf("mozilla/3") != -1) )
        {
        //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
        browser = "Netscape-?";

        } else if (browser.contains("firefox"))
        {
        browser=(browser.substring(browser.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if(browser.contains("rv"))
        {
        browser="IE-" + browser.substring(browser.indexOf("rv") + 3, browser.indexOf(")"));
        } else
        {
        browser = "UnKnown, More-Info: "+browser;
        }
//        log.info("Operating System======>"+os);
        log.info("Browser Name==========>"+browser1);
//        String remoteAddress = request.getHeader("X-FORWARDED-FOR");//nie działa, daje nulla
        String ipAddress = request.getRemoteAddr();//bdb
        response.getWriter().append(ipAddress).append(LocalDate.now().toString()).append(browser1);
    }
//    private String getHttpMethodFrom(HttpServletRequest httpRequest) {
//        String method = httpRequest.getHeader();
//        if (method == null) {
//            method = httpRequest.getMethod
//                    ();
//        }
//        return method;
//    }
//    Wyświetl w przeglądarce poniższe informacje (wykorzystaj metodę getHeader obiektu typu HttpServletRequest):
//
//    Adres IP
//    Przeglądarkę
//    Aktualny czas (wykorzystaj LocalTime.now() )

}
//    Java there is no direct way to get browser and OS related information. //WOW
//
//        But to get this few third-party tools are available.
//
//        Instead of trusting third-party tools, I suggest you to parse the user agent.
//
//        String  browserDetails  =   request.getHeader("User-Agent");
//
//        By doing this you can separate the browser details and OS related information easily according to your requirement. PFB the snippet for reference.
//
//        String  browserDetails  =   request.getHeader("User-Agent");
//        String  userAgent       =   browserDetails;
//        String  user            =   userAgent.toLowerCase();
//
//        String os = "";
//        String browser = "";
//
//        log.info("User Agent for the request is===>"+browserDetails);
//        //=================OS=======================
//        if (userAgent.toLowerCase().indexOf("windows") >= 0 )
//        {
//        os = "Windows";
//        } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
//        {
//        os = "Mac";
//        } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
//        {
//        os = "Unix";
//        } else if(userAgent.toLowerCase().indexOf("android") >= 0)
//        {
//        os = "Android";
//        } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
//        {
//        os = "IPhone";
//        }else{
//        os = "UnKnown, More-Info: "+userAgent;
//        }
//        //===============Browser===========================
//        if (user.contains("msie"))
//        {
//        String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
//        browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
//        } else if (user.contains("safari") && user.contains("version"))
//        {
//        browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
//        } else if ( user.contains("opr") || user.contains("opera"))
//        {
//        if(user.contains("opera"))
//        browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
//        else if(user.contains("opr"))
//        browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
//        } else if (user.contains("chrome"))
//        {
//        browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
//        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
//        {
//        //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
//        browser = "Netscape-?";
//
//        } else if (user.contains("firefox"))
//        {
//        browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
//        } else if(user.contains("rv"))
//        {
//        browser="IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
//        } else
//        {
//        browser = "UnKnown, More-Info: "+userAgent;
//        }
//        log.info("Operating System======>"+os);
//        log.info("Browser Name==========>"+browser);