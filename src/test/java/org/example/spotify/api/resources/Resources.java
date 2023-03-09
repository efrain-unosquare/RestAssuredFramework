package org.example.spotify.api.resources;

import io.restassured.response.Response;
import org.example.spotify.api.routes.ApiRoutes;
import org.example.spotify.builder.SpecBuilder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.example.spotify.api.routes.ApiRoutes.API;
import static org.example.spotify.api.routes.ApiRoutes.TOKEN;
import static org.example.spotify.builder.SpecBuilder.getAccountRequestSpecToken;

public class Resources {
    public static Response post(String path, String token, Object request){

        return given(SpecBuilder.getRequestSpec())
                    .auth()
                    .oauth2(token)
                    .body(request).
               when()
                    .post(path).
               then()
                    .spec(SpecBuilder.getResponseSpec())
                    .extract()
                    .response();
    }

    public static Response postToken(HashMap<String, String> formParams){
        return  given(getAccountRequestSpecToken())
                        .formParams(formParams).
                when()
                        .post(API  + TOKEN).
                then()
                        .spec(SpecBuilder.getResponseSpec())
                        .extract()
                        .response();
    }

    public static Response get(String path, String token){
        return  given(SpecBuilder.getRequestSpec())
                .auth()
                .oauth2(token).
                when()
                    .get(path).
                then()
                    .spec(SpecBuilder.getResponseSpec())
                    .extract()
                    .response();
    }

    public static Response update(String path, String token, Object request){
        return given(SpecBuilder.getRequestSpec())
                    .auth()
                    .oauth2(token)
                    .body(request).
                when()
                    .put(path).
                then()
                    .spec(SpecBuilder.getResponseSpec())
                    .extract()
                    .response();
    }
}
