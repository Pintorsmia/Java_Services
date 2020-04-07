package prix;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.text.DecimalFormat;

@Path("/calcul")
public class CalculPrix {
    private int prixkm = 5; //prix au km  en €
    private double dollar = 1.1;
    private double francsuisse = 1.06;
    private double bitcoin = 0.00012;

        @GET
        @Path("/test")
        @Produces("text/plain")
        public String test (){
            return "test";
        }


        @GET
        @Path("{distance}/{devise}")
        @Produces("text/plain")
        public String getCalcul(@PathParam("distance") double distance, @PathParam("devise") String devise) {
            DecimalFormat df = new DecimalFormat("#.##");
            double result = 0;
            double prixtmp = distance * this.prixkm;


            switch (devise.toLowerCase()){
                case "euro":
                    result = prixtmp;
                    break;
                case "dollar":
                    result = this.dollar * prixtmp;
                    break;
                case "francsuisse":
                    result = this.francsuisse * prixtmp;
                    break;
                case "bitcoin":
                    result = this.bitcoin * prixtmp;
                    break;
                default:
                    return "Erreur devise inconnue";
            }
            return (df.format(result)) + " " + devise ;


// Exemple d'url --> http://item-s83074:8080/SrvPrix2_war/API/calcul/12/euro
    }
}
