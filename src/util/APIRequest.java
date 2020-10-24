package util;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIRequest {
    public static String get(int year, String season) {

        String result = "";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.jikan.moe/v3/season/" + Integer.toString(year) + "/" + season))
                .header("accept","application/json")
                .build(); //Create HTTP GET request for api

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Send request and store response
            System.out.println(response.body());
            result = (String) response.body();
        } catch(Exception e){
            System.out.println("Failed request" + e);
        }
        //TODO: PARSE JSON AND RETURN TITLES
        return result; //Return response
    }
}
