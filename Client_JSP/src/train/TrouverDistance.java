package train;

import calcul.Distance;
import calcul.DistanceService;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TrouverDistance {
    public static void main(String[] args) {
        calcul.Distance service = new DistanceService().getDistancePort();
//invoke business method
        Double test = service.distance(45.899247,6.129384,45.564601,5.917781);
        System.out.println(test);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(test));
    }
}
