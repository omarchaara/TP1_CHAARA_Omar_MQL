package com.Webapplication.servlet;



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.*;
import java.util.*;

public class NomAge extends HttpServlet {
    
    private int calculAge(String dateNaissanceString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissanceDate = df.parse(dateNaissanceString);
        Calendar dateNaissanceCalendar = Calendar.getInstance();
        dateNaissanceCalendar.setTime(dateNaissanceDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateNaissanceCalendar.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dateNaissanceCalendar.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dateNaissanceCalendar.get(Calendar.MONTH)
            && today.get(Calendar.DAY_OF_MONTH) <
            dateNaissanceCalendar.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String dateNaissanceString = request.getParameter("dateNaissance");
        
        try {
            int age = calculAge(dateNaissanceString);
            out.println("<html><body>");
            out.println("Bonjour " + nom + " " + prenom + "<br>");
            out.println("Vous avez " + age + " ans.");
            out.println("</body></html>");
        } catch (ParseException e) {
            out.println("<html><body>");
            out.println("Bonjour " + nom + " " + prenom + "<br>");
            out.println("'" + dateNaissanceString + "' n'est pas le bon format 'JJ/MM/AAAA'.");
            out.println("</body></html>");
        }
    }
}
