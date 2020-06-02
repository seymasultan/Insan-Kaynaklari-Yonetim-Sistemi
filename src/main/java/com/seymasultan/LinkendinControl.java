package com.seymasultan;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.SimpleAttributeSet;

@Controller

public class LinkendinControl {

    @Autowired
    UsersDAO userDAO;

    @Autowired
    private AdvertDAO advertDao;


    private String clientId="770w30vzh4gjzi";
    private String clientSecret="mQVfp0JoTh6cXgjD";
    private String redirectUrl="http://localhost:8090/loginLinkedin";

    @GetMapping("/linkedin")
    public String authorization() {

            String authorizationUri = "https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUrl + "&scope=r_liteprofile%20r_emailaddress";
            return "redirect:" + authorizationUri;
    }

    @GetMapping("/loginLinkedin")
    public String home(@RequestParam("code") String authorizationCode, Model model,@SessionAttribute("activeUser") Users user) throws JSONException, SQLException {

        String accessTokenUri ="https://www.linkedin.com/oauth/v2/accessToken?grant_type=authorization_code&code="+authorizationCode+"&redirect_uri="+redirectUrl+"&client_id="+clientId+"&client_secret="+clientSecret+"";

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        String accessTokenRequest = restTemplate.getForObject(accessTokenUri, String.class);
        JSONObject jsonObjOfAccessToken = new JSONObject(accessTokenRequest);
        String accessToken = jsonObjOfAccessToken.get("access_token").toString();
        System.out.println("Access Token : " + accessToken);
        String profileUrl = "https://api.linkedin.com/v2/me";
        String imageUrl = "https://api.linkedin.com/v2/me?projection=(id,profilePicture(displayImage~:playableStreams))";
        String emailUrl= "https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))";

        try {
            JsonObject profileData = sendGetRequest(profileUrl, accessToken);
            JsonObject profilePicture = sendGetRequest(imageUrl,accessToken);
            JsonObject emailData = sendGetRequest(emailUrl,accessToken);
            System.out.println("EmailData : " + emailData.toString() );
            System.out.println("profilData: " + profileData.toString());
            System.out.println("profilPicture :" + profilePicture.toString());
            String soyad = profileData.getString("localizedLastName");
            String ad =  profileData.getString("localizedFirstName");
            String id = profileData.getString("id");
            JsonObject profilePP = profilePicture.getJsonObject("profilePicture");
            JsonObject displayImage = profilePP.getJsonObject("displayImage~");
            JsonArray elements = displayImage.getJsonArray("elements");
            JsonArray identifiers = elements.get(2).asJsonObject().getJsonArray("identifiers");
            String image = identifiers.get(0).asJsonObject().getString("identifier");
            JsonArray elementsMail = emailData.getJsonArray("elements");
            JsonObject handle = elementsMail.getJsonObject(0).getJsonObject("handle~");
            String email = handle.getString("emailAddress");
            System.out.println("MAİL : " + email);

            user.setId(id);
            user.setIsim(ad+" "+soyad);
            user.setMail(email);
            user.setProfil(image);
            Users user2=new Users(id,ad+" "+soyad ,email,image);

            if(!user2.getId().equals(userDAO.id(user2)))
                userDAO.userSave(user2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userpage(model,user);

    }

    private static JsonObject sendGetRequest(String urlString, String accessToken) throws Exception {
        URL url = new URL(urlString);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);
        con.setRequestProperty("cache-control", "no-cache");
        con.setRequestProperty("X-Restli-Protocol-Version", "2.0.0");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();

        JsonReader jsonReader = Json.createReader(new StringReader(jsonString.toString()));

        return jsonReader.readObject();
    }

    @GetMapping("/userPage")
    public String userpage(Model model,@SessionAttribute("activeUser") Users user) throws SQLException {

            model.addAttribute("activeUser", user);
            return "userpage";
    }

    @GetMapping("/user/{userId}")  //insan kaynaklarından profil bakma
    public String profile(@PathVariable("userId") String userId,Model model) throws SQLException {

        Users user = userDAO.userGet(userId);

        return userpage(model,user);
    }



}
