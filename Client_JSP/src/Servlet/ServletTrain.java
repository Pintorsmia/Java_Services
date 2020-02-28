package Servlet;

import calcul.DistanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;


@WebServlet(name = "ServletTrain")
public class ServletTrain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //Methode pour arrondir
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        // Recuperation des parametres
        Double latA = Double.parseDouble(request.getParameter("latA"));
        Double lonA= Double.parseDouble(request.getParameter("lonA"));
        Double latB = Double.parseDouble(request.getParameter("latB"));
        Double lonB = Double.parseDouble(request.getParameter("lonB"));
        String devise = request.getParameter("devise");


        calcul.Distance service = new DistanceService().getDistancePort();
        Double distance = service.distance(latA,lonA,latB,lonB);


        PrintWriter out = response.getWriter();
        out.print("Resultat = "+df.format((double) distance)+" km");

        //Requetes REST vers mon services de calcul des prix

        if (distance !=0) {
            StringBuilder SB = new StringBuilder();
            URL url = new URL("http://item-s83074:8080/SrvPrix_war3315487828590068401/API/calcul/" + distance + "," + devise);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                SB.append(line);
            }
            rd.close();
            out.write(df.format(SB.toString()));

            //Il faut modifier le service afin qu'il fasse l'arrondi avant de l'envoyer

        }



        /*
        if(pass.equals("pass"))
        {
            RequestDispatcher rd=request.getRequestDispatcher("servlet2");
            rd.forward(request, response);
        }
        else
        {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);

         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
