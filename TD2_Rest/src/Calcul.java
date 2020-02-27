import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
@Path("/calcul")
public class Calcul {
        @GET
        @Path("{int1},{int2}")
        @Produces("text/plain")
        public String getCalcul(@PathParam("int1") int a, @PathParam("int2") int b) {
            int result =  a+b;
            return Integer.toString(result) ;
        }

// Exemple d'url --> http://localhost:8080/TD2_Rest_war_exploded/API/calcul/127,65
}
