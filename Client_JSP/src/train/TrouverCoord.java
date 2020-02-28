package train;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import
import org.json.JSONObject;

public class TrouverCoord {

    public TrouverCoord() throws IOException {
        JSONObject json = new JSONObject();
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://data.sncf.com/api/records/1.0/search//?dataset=referentiel-gares-voyageurs&q=annecy&lang=FR");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try {
            InputStream in = new BufferedInputStream(conn.getInputStream());
            System.out.println(readStream(in));
        } finally {
            conn.disconnect();
        }



        /*
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println(result.toString());*/
    }

    private String readStream(InputStream is) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }

}
