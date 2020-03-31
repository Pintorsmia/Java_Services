
package calcul;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DistanceService", targetNamespace = "http://calcul/", wsdlLocation = "https://distance-projetusmb.appspot.com/services/Distance?wsdl")
public class DistanceService
    extends Service
{

    private final static URL DISTANCESERVICE_WSDL_LOCATION;
    private final static WebServiceException DISTANCESERVICE_EXCEPTION;
    private final static QName DISTANCESERVICE_QNAME = new QName("http://calcul/", "DistanceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://distance-projetusmb.appspot.com/services/Distance?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DISTANCESERVICE_WSDL_LOCATION = url;
        DISTANCESERVICE_EXCEPTION = e;
    }

    public DistanceService() {
        super(__getWsdlLocation(), DISTANCESERVICE_QNAME);
    }

    public DistanceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DISTANCESERVICE_QNAME, features);
    }

    public DistanceService(URL wsdlLocation) {
        super(wsdlLocation, DISTANCESERVICE_QNAME);
    }

    public DistanceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DISTANCESERVICE_QNAME, features);
    }

    public DistanceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DistanceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Distance
     */
    @WebEndpoint(name = "DistancePort")
    public Distance getDistancePort() {
        return super.getPort(new QName("http://calcul/", "DistancePort"), Distance.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Distance
     */
    @WebEndpoint(name = "DistancePort")
    public Distance getDistancePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://calcul/", "DistancePort"), Distance.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DISTANCESERVICE_EXCEPTION!= null) {
            throw DISTANCESERVICE_EXCEPTION;
        }
        return DISTANCESERVICE_WSDL_LOCATION;
    }

}
