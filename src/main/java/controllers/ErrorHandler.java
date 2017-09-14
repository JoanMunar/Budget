package controllers;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class ErrorHandler extends HttpServlet {

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Error";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");

        out.println("<h2>Ha sorgit un error en la pàgina, possiblement per un dels següents errors:<br>\n" +
                "                - Ha introduit un dada errònea dins els camps del formulari.<br>\n" +
                "                - Volia trobar aquesta pàgina.<br>" +
                "                - El formulari esta buit.\n" +
                "        </h2>");
        out.println("<a href=\"/Home\">Tornar enrera</a>");
        out.println("</body>");
        out.println("</html>");

    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}