package org.example.spotify.api;

import io.restassured.response.Response;
import org.example.spotify.utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;

import static org.example.spotify.api.resources.Resources.postToken;

public class TokenManager {

    private static String accessToken;
    private static Instant expiryTime;

    public synchronized static String getToken(){
        try {
            if (accessToken == null || Instant.now().isAfter(expiryTime)){
                System.out.println("Renewing token ....");
                Response response = renewToken();
                accessToken = response.path("access_token");
                int durationValidToken = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(durationValidToken - 300);
            }else {
                System.out.println("---------- Token is good to use ---------");
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to get token"
                    , e);
        }
        return accessToken;
    }

    private static Response renewToken(){
        HashMap<String, String> formParams = new HashMap<String, String>();
        formParams.put("client_id", ConfigLoader.getInstance().getClientId());
        formParams.put("client_secret", ConfigLoader.getInstance().getClientSecret());
        formParams.put("grant_type",ConfigLoader.getInstance().getGrantType());
        formParams.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());

        Response response = postToken(formParams);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Something went wrong trying to get a new token");
        }
        return response;
    }
}
