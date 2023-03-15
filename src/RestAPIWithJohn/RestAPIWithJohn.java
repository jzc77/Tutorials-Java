package RestAPIWithJohn;

import java.net.URI;
import java.net.http.HttpRequest;
// https://youtu.be/9oq7Y8n1t00?t=883

public class RestAPIWithJohn {
    public static void main(String[] args) throws Exception {

        Transcript transcript = new Transcript();
        transcript.setAudio_url("https://bit.ly/3yxKEIY");

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", System.getenv("API_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(""))
    }
}
