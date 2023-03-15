package RestAPIWithJohn;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
// https://youtu.be/9oq7Y8n1t00?t=883

public class RestAPIWithJohn {
    public static void main(String[] args) throws Exception {

        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://bit.ly/3yxKEIY");
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);  // {"audio_url":"https://bit.ly/3yxKEIY"}

        // SN: How to send all the information as a POST request to the specified URL
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", System.getenv("API_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        // SN: How to receive all the information we requested as a POST request
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());  // Second argument means that we expect it to send back a string in response
        System.out.println(postResponse.body());
    }
}
