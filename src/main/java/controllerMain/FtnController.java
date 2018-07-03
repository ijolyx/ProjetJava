package controllerMain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import model.WeatherPojo;

@Path("/meteo")
public class FtnController extends HttpServlet {

    @GET()
    @Path("/{ville}")
    public String getFtnDatas(@PathParam("ville") String ville) {

        URL url = null;

        String data = "";

        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ville + "&appid=b934232a8f10ff55be66ab72e207331c");

            data = this.connexion(url);

        } catch (MalformedURLException e) {
            System.out.println("nani");
        } catch (IOException e) {
            System.out.println("wtff");
        }

        return data;
    }

    @GET
    @Path("/id/{lat}" + "&" + "{lon}")
    public String getCoordWeather(@PathParam("lat") String lat, @PathParam("lon") String lon) {

        String data = "";
        URL url = null;
        try {

            url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=b934232a8f10ff55be66ab72e207331c");
            data = this.connexion(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FtnController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FtnController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(data.toString());

        return data;
    }

    private String connexion(URL url) throws IOException {
        HttpURLConnection con = null;
        WeatherPojo pj = null;
        String data = "";
        con = (HttpURLConnection) url.openConnection();

        con.setDoInput(true);
        con.setRequestMethod("GET");
        con.setDoOutput(true);

        System.out.println(con.toString());
        int status = con.getResponseCode();
        System.out.println(con.getHeaderField("Access-Control-Allow-Origin"));
        System.out.println(con.getHeaderField("Access-Control-Allow-Methods"));
        System.out.println(con.getResponseMessage());
        System.out.println(status);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            pj = objectMapper.readValue(content.toString(), WeatherPojo.class);
        } catch (IOException ex) {
            Logger.getLogger(FtnController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(pj.getMain().getTemp());
        double celsius = Double.parseDouble(pj.getMain().getTemp());
        celsius = celsius - 273.15;
        int degres = (int) celsius;

        double celsiusMax = Double.parseDouble(pj.getMain().getTemp_max());
        celsiusMax = celsiusMax - 273.15;
        int degresMax = (int) celsiusMax;

        double celsiusMin = Double.parseDouble(pj.getMain().getTemp_min());
        celsiusMin = celsiusMin - 273.15;
        int degresMin = (int) celsiusMin;

        pj.getMain().setTemp(Integer.toString(degres));
        pj.getMain().setTemp_max(Integer.toString(degresMax));
        pj.getMain().setTemp_min(Integer.toString(degresMin));
        Gson g = new Gson();
        data = g.toJson(pj);

        // data = pj.getMain().getTemp();
        //  data = objectMapper.writeValueAsString(pj);
        in.close();
        con.disconnect();

        return data;

    }

}
