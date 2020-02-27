package prix;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calcul")
public class CalculPrix {
    private int prixkm = 5; //prix au km en €
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
        @Path("{distance},{devise}")
        @Produces("text/plain")
        public String getCalcul(@PathParam("distance") double distance, @PathParam("devise") String devise) {

            double result = 0;
            double prixtmp = distance * this.prixkm;


            switch (devise.toLowerCase()){
                case "euro":
                    result = prixtmp;
                    break;
                case "dollar":
                    result = this.dollar * prixtmp;
                    break;
                case "franc suisse":
                    result = this.francsuisse * prixtmp;
                    break;
                case "bitcoin":
                    result = this.bitcoin * prixtmp;
                    break;
                default:
                    return "Erreur devise inconnue";
            }
            return Double.toString(result) + " " + devise ;


// Exemple d'url --> http://item-s83074:8080/SrvPrix_war3315487828590068401/API/calcul/12,euro
    }
}
