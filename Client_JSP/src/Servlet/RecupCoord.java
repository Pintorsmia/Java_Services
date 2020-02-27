package Servlet;

import calcul.DistanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servletCoord")
public class RecupCoord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Double latA = Double.parseDouble(request.getParameter("latA"));
        Double lonA= Double.parseDouble(request.getParameter("lonA"));
        Double latB = Double.parseDouble(request.getParameter("latB"));
        Double lonB = Double.parseDouble(request.getParameter("lonB"));

        calcul.Distance service = new DistanceService().getDistancePort();
        Double result = service.distance(latA,lonA,latB,lonB);


        PrintWriter out = response.getWriter();
        out.print("Resultat = "+result);
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
