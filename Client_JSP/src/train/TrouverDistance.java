package train;

import calcul.Distance;
import calcul.DistanceService;

public class TrouverDistance {
    public static void main(String[] args) {
        calcul.Distance service = new DistanceService().getDistancePort();
//invoke business method
        System.out.println(service.distance(45.899247,6.129384,45.564601,5.917781));
    }
}
