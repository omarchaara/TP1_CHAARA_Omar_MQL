package com.Webapplication.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Formulaire extends HttpServlet {
	
   
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String nom = request.getParameter("txtNom");
         String prenom = request.getParameter("txtPrenom");
         String dateNaissance = request.getParameter("txtDateNaissance");
         
         if (nom == null) nom = " ";
         if (prenom == null) prenom = " ";
         if (dateNaissance == null) dateNaissance = " ";
         
         response.setContentType("text/html");
         try (PrintWriter out = response.getWriter()) {
         	out.println("<!DOCTYPE html>");
         	out.println("<html> ");
         	out.println("<head> ");
         	out.println("<title> Veuillez vous identifier </title> ");
         	out.println("<link rel='stylesheet' type='text/css' href='style.css' /> ");
         	out.println("</head> ");    
         	out.println("<body> ");

         	out.println("<h1>Veuillez vous identifier</h1> ");

         	out.println("<form method='post' action='NomAge'>\n");
         	out.println("<label for='txtNom'> Nom :</label>");
         	out.println("<input id='txtNom' name='nom' type='text' value= '" + nom + "' required /><br/>");
         	out.println("<label for='txtPrenom'> Prenom :</label>");
         	out.println("<input name='prenom' type='text' value='" + prenom + "' required /><br/>");
         	out.println("<label for='txtDateNaissance'> Date de Naissance (JJ/MM/AAAA) :</label>");
         	out.println("<input name='dateNaissance' type='text' value='" + dateNaissance + "' required /><br/>");
         	out.println("<br/>\n");
         	out.println("<input name='btnConnect' type='submit' value='Soumettre'>\n");

         	out.println("</body> ");
         	out.println("</html> "); 
	}}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
