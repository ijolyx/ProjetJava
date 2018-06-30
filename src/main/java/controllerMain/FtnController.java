package controllerMain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import javax.servlet.http.HttpServlet;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.core.UriBuilder;
import model.Coord;
import model.WeatherPojo;


@Path("/meteo")
public class FtnController extends HttpServlet{



    @GET()    
    @Path("/{ville}")
    public String getFtnDatas(@PathParam("ville") String ville) {

        

URL url = null;
        HttpURLConnection con = null;
        String data ="";
        WeatherPojo  pj = null;
        
        
        
            
    try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ville + "   &appid=b934232a8f10ff55be66ab72e207331c");
            
            con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setRequestMethod("GET");
         //   con.addRequestProperty("TRN-Api-Key", "e467882d-19ea-48c0-a588-0c8fb687927c");
            
            
            
            con.setDoOutput(true);

           
            System.out.println(con.toString());
            int status = con.getResponseCode();
            System.out.println(con.getHeaderField("Host"));
            System.out.println(con.getResponseMessage());
            System.out.println(status);

           
             BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println("T OUU");
            System.out.println(content.toString());
            // Gson g = new Gson();
           // java.lang.reflect.Type collectionType = new TypeToken<Collection<WeatherPojo>>(){}.getType();
           // Collection<WeatherPojo> enums = g.fromJson(content.toString(), collectionType);
             
          // pj = g.fromJson(content.toString(), WeatherPojo.class);
            
           // System.out.println(pj.getCoord().toString());
           
            ObjectMapper objectMapper = new ObjectMapper();
            pj = objectMapper.readValue(content.toString(), WeatherPojo.class);
            
            System.out.println(pj.getCoord().toString());
          //  data = objectMapper.writeValueAsString(pj);
            
            in.close();
            con.disconnect();
           
         //   data = content.toString();
            
            
            System.out.println("LATITUDE!!!!!!!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("nani");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wtff");
        }
     
    
return data;
    }
}
