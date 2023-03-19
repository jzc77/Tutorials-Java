package RestAPIWithJohn;
// https://www.youtube.com/watch?v=9oq7Y8n1t00 (How To Call a REST API In Java - Simple Tutorial)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

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
        System.out.println(postResponse.body());  // json object

        // 1st parameter = JSON string that you want to convert into an object
        // 2nd parameter = the class you want to convert JSON into
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        System.out.println(transcript.getId());  // id of the json object

        // SN: Another GET request to get all the information as a GET request from the specified URL with specific id
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", System.getenv("API_KEY"))
                .GET()  // No request body needed inside; GET() is default, so don't even need to include here
                .build();

        // Need to repeatedly send GET request until the status is completed (i.e. not queued), meaning the transcript is done or file has been processed
        while (true) {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());  // Second argument means that we expect it to send back a string in our call
            transcript = gson.fromJson(getResponse.body(), Transcript.class);
            System.out.println(transcript.getStatus());

            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
                break;
            }

            Thread.sleep(1000);  // wait for 1 second before GET request tries again
        }

        // Outside of while loop means we know that the file processing has completed
        System.out.println("Transcription completed!");
        System.out.println(transcript.getText());
    }
}
