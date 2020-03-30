package train;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Class.*;
public class TrouverTrain {
        public static void main(String[] args) throws IOException {
            String Token = "7d5b4417-f093-461b-b50b-b95d06cc06af";
            TrouverTrain t = new TrouverTrain();
            ArrayList Tra = t.getTrajet(87746008,87741009,Token);
            System.out.println(Tra.toString());
        }

    public TrouverTrain() {
    }

    public int getUIC(String ville) throws IOException {
        StringBuilder result = new StringBuilder();
        int UIC = -1;
        URL url = new URL("https://data.sncf.com/api/records/1.0/search//?dataset=referentiel-gares-voyageurs&q=" + ville + "&lang=FR");
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
                UIC = (int) json.getJSONArray("records").getJSONObject(0).getJSONObject("fields").get("pltf_uic_code");
                System.out.println(UIC);
            } else {
                System.out.println("Pas de gares dans cette ville");
            }
        } finally {
            conn.disconnect();
            return UIC;
        }
    }

    public ArrayList getTrajet (int UICA, int UICB, String token) throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList Trajets = new ArrayList();

        URL url = new URL("https://api.sncf.com/v1/coverage/sncf/journeys?from=stop_area:OCE:SA:"+UICA+"&to=stop_area:OCE:SA:"+UICB+"&min_nb_journeys=5&key="+token);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        /*int responseCode = conn.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);*/
        try {
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
            for (String line = r.readLine(); line != null; line = r.readLine()) {
                result.append(line);
            }
            in.close();
            JSONObject json = new JSONObject(result.toString());
            System.out.println(json);
            System.out.println((String) json.getJSONArray("journeys").getJSONObject(0).get("departure_date_time"));
            System.out.println(json.getJSONArray("journeys").length());
            //verif qu'il y'a au moins 1 voyage
            if (json.getJSONArray("journeys").length() > 2) {
                for (int nbvoyage = 0; nbvoyage < (int) json.getJSONArray("journeys").length() ; nbvoyage++) {
                    System.out.println("journey " + nbvoyage);
                    Trajets.add(new Trajet(
                            (String) json.getJSONArray("journeys").getJSONObject(nbvoyage).get("departure_date_time"),
                            (String) json.getJSONArray("journeys").getJSONObject(nbvoyage).get("arrival_date_time"),
                            (int) json.getJSONArray("journeys").getJSONObject(nbvoyage).get("duration"),
                            (String) json.getJSONArray("journeys").getJSONObject(nbvoyage).getJSONArray("sections").getJSONObject(1).getJSONObject("display_informations").get("physical_mode")
                    ));

                }
            } else {
                System.out.println("Pas de voyage disponible");
            }
        } finally {
            conn.disconnect();
           // System.out.println(Trajets[0].toString());
            return Trajets;
        }
    }
}
