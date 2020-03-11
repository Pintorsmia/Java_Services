package train;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrouverCoord {

    public TrouverCoord() {
    }

    public double[] getCoord(String ville) throws IOException {
        StringBuilder result = new StringBuilder();
        double[] coords = new double[2];
        URL url = new URL("https://data.sncf.com/api/records/1.0/search//?dataset=referentiel-gares-voyageurs&q="+ville+"&lang=FR");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try {
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                result.append(line);
            }
            in.close();
            JSONObject json = new JSONObject(result.toString());
            System.out.println(json);
            //verif qu'il y'a une gare dans la ville indique
            if (json.getInt("nhits") > 0) {

                double coordA = (double) json.getJSONArray("records").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").get(0);
                double coordB = (double) json.getJSONArray("records").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").get(1);
                coords[1] = coordA;
                coords[0] = coordB;
                System.out.println(coordA);
            } else {
                System.out.println("Pas de gares dans cette ville");
            }
        } finally {
            conn.disconnect();
            return coords;
        }
    }
}

