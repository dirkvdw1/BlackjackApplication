package Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Player;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.springframework.boot.web.servlet.server.Session;
import org.apache.http.client.methods.HttpPost;

import java.util.ArrayList;
import java.util.List;

public class Login {

    public Boolean registerPlayer(String name, String password) {


        HttpPost post = new HttpPost("http://localhost:8080/register");
        int id;
        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("password", password));


        String dbObject = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            dbObject = EntityUtils.toString(response.getEntity());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Player player = ConvertFromJsonToObject(dbObject);
        if(player != null){
            return true;
        }
        return false;
    }

    private Player ConvertFromJsonToObject(String dbObject) {

        Player player = new Player();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
             player = objectMapper.readValue(dbObject, Player.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
            return player;
    }
}
