package calcul;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class Distance {
    @WebMethod
    public Double Distance(Float latA, Float lonA, Float latB, Float lonB) {

        Double result = Math.acos(Math.sin(Math.toRadians(latA))*Math.sin(Math.toRadians(latB))+Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))*(Math.toRadians(lonB)-Math.toRadians(lonA)));
        System.out.println(result);
        return result;
    }

  /*
  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }*/
}
