package org.example.spotify.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.spotify.api.resources.Resources;
import org.example.spotify.pojos.Playlist;
import org.example.spotify.utils.ConfigLoader;

import static org.example.spotify.api.TokenManager.getToken;
import static org.example.spotify.api.routes.ApiRoutes.PLAYLISTS;
import static org.example.spotify.api.routes.ApiRoutes.USERS;


public class PlayListApi {
    @Step
    public static Response post(Playlist request){
        return Resources.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken(), request);
    }

    public static Response post(String token, Playlist request){
        return Resources.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, token, request);
    }

    public static Response get(String playlist_id){
        return Resources.get(PLAYLISTS + "/" + playlist_id, getToken());
    }

    public static Response update(Playlist request, String playlist_id){
        return Resources.update(PLAYLISTS + "/" + playlist_id, getToken(), request);
    }
}
