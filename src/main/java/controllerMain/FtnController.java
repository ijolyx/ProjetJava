package controllerMain;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.core.UriBuilder;


@Path("/meteo")
public class FtnController extends HttpServlet{

private static final long serialVersionUID = 1L;
	public static final URI BASE_URI = getBaseURI();

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/LOLZ/").build();
	}

    @GET()    
    @Path("/{ville}")
    public String getFtnDatas(@PathParam("ville") String ville) {

        

URL url = null;
        HttpURLConnection con = null;
        String data ="";
        
        
        
            
    try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ville + "&appid=b934232a8f10ff55be66ab72e207331c");
            
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
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content.toString());
            data = content.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    
return data;
    }
}
