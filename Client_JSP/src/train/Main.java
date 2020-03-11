package train;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        TrouverCoord tc = new TrouverCoord();
        double [] nb = tc.getCoord("chambéry");
        System.out.println(nb[0]);
        System.out.println(nb[1]);
         /*
        StringBuilder result = new StringBuilder();
        URL url = new URL("http://api.navitia.io/v1/coverage/sncf/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "7d5b4417-f093-461b-b50b-b95d06cc06af");
        InputStream in = new BufferedInputStream(conn.getInputStream());
        BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            result.append(line);
        }
        in.close();
        JSONObject json = new JSONObject(result.toString());
        System.out.println(json);
        */

    }
}
