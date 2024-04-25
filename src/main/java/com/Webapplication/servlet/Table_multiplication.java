package com.Webapplication.servlet;



import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Table_multiplication extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Multiplication Table</title>");

		out.println("<style>");

		out.println("td {");
		out.println("  width: 90px;"); // Largeur fixe pour chaque cellule
		out.println("  height: 30px;"); // Hauteur fixe pour chaque cellule
		out.println("  text-align: center;"); // Centrage du texte
		out.println("}");
		out.println(".gray {");
		out.println("  background-color: #f0f0f0;"); // Couleur de fond grise
		out.println("}");
		out.println(".white {");
		out.println("  background-color: #ffffff;"); // Couleur de fond blanche
		out.println("}");
		out.println(".center {");
		out.println("  text-align: center;"); // Alignement du texte au centre
		out.println("}");
		out.println(".bold {");
		out.println("  font-weight: bold;"); // Texte en gras
		out.println("}");
		out.println(".yellow {");
		out.println("  background-color: yellow;"); // Couleur de fond jaune
		out.println("}");
		out.println(".small {");
		out.println("  font-size: smaller;"); // Taille de police plus petite
		out.println("}");

		out.println("</style>");

		out.println("</head>");
		out.println("<body>");
		out.println("<p class='center'>Table de multiplication</p>");
		out.println("<table border='1'>");

		// Première ligne avec les chiffres 1 à 10
		out.println("<tr><td class='yellow bold small'>*</td>");
		for (int i = 1; i <= 10; i++) {
			out.println("<td class='gray bold small'>" + i + "</td>");
		}
		out.println("</tr>");

		// Génération des autres lignes du tableau
		for (int i = 1; i <= 10; i++) {
			out.println("<tr>");
			// Première colonne avec les chiffres 1 à 10
			out.println("<td class='gray bold small'>" + i + "</td>");
			// Multiplication et affichage des résultats
			for (int j = 1; j <= 10; j++) {

				out.println("<td class='white small'>" + (i * j) + "</td>");

			}
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
