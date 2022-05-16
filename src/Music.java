import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Music {

    private String baseUrl;
    private String apiKey;

    public Music()
    {
        baseUrl = "http://ws.audioscrobbler.com/2.0/";
        apiKey = "ae1984a8b387844ffd7e00669182f0fc";
    }

    public String makeAPICallForAlbum(String album, String artist)
    {
        String endPoint = "&format=json";
        String url = baseUrl + "?method=album.getinfo&api_key=" + apiKey + "&artist=" + artist + "&album=" + album  +endPoint;

        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void parseAlbum(String json)
    {
        JSONObject jsonObj = new JSONObject(json);
        JSONObject albumObj = jsonObj.getJSONObject("album");
        System.out.println("Name: " + albumObj.getString("name") + ", Artist = " + albumObj.getString("artist") + ", ID = " + albumObj.getInt("id") + ", URL = " + albumObj.getString("url") + ", Release Date = "  + albumObj.getString("release date") + ", Listeners = " + albumObj.getInt("playcount"));
        System.out.println();
        JSONObject trackObj = jsonObj.getJSONObject("tracks");
        JSONArray trackArr = trackObj.getJSONArray("tracks");

        for (int i = 0; i < trackArr.length(); i++)
        {
            JSONObject rank1 = trackArr.getJSONObject(1);
            System.out.println("Name = " + rank1.getString("name") + ", Duration = " + rank1.getString("duration") + ", URL = " + rank1.getString("url"));
        }
    }
}
