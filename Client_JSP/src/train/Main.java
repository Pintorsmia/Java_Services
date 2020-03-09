package train;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TrouverCoord tc = new TrouverCoord();
        double [] nb = tc.getCoord("chambéry");
        System.out.println(nb[0]);
        System.out.println(nb[1]);
    }
}
