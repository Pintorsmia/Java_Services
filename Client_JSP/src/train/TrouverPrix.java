package train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TrouverPrix {

    public static void main(String[] args) throws IOException {
            StringBuilder result = new StringBuilder();
            URL url = new URL("http://item-s83074:8080/SrvPrix_war3315487828590068401/API/calcul/12,euro");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        System.out.println(result.toString());
    }
}
