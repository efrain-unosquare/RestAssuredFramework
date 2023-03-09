package org.example.spotify.test;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.example.spotify.api.PlayListApi;
import org.example.spotify.pojos.ErrorResponse;
import org.example.spotify.pojos.Playlist;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlayListTest extends BaseTest {
    static private String playlist_id = "";


    @Story("Create a playlist story")
    @Link("https://example.org")
    @Link(name = "allure", type = "myLink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("This is a description")
    @Test(description = "Create a Playlist")
    public void testCreatePlaylist() {
        Playlist requestPlaylist = requestBuilder("New PlayList", "New playlist description", false);

        Response response = PlayListApi.post(requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(201));

        Playlist responsePlayList = response.as(Playlist.class);

        playlist_id = responsePlayList.getId();

        assertThat(responsePlayList.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlayList.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlayList.get_public(), equalTo(requestPlaylist.get_public()));
    }
    @Story("Create a playlist story")
    @Test(description = "Retrieve a specific playlist using the id")
    public void testGetPlaylist() {
        Playlist requestPlaylist = requestBuilder("New PlayList", "New playlist description", false);

        Response response = PlayListApi.get(playlist_id);
        assertThat(response.getStatusCode(), equalTo(200));

        Playlist playlist = response.as(Playlist.class);

        assertThat(playlist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(playlist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(playlist.get_public(), equalTo(requestPlaylist.get_public()));
    }
    @Story("Create a playlist story")
    @Test(description = "Update a created playlist")
    public void testUpdatePlaylist() {
        Playlist requestPlaylist = requestBuilder("Updated Playlist", "Updated playlist description", false);

        Response  response = PlayListApi.update(requestPlaylist, playlist_id);
        assertThat(response.getStatusCode(), equalTo(200));

    }
    @Story("Create a playlist story")
    @Test(description = "No able to create a playlist due a wrong request is passed")
    public void testNotBeAbleCreatePlaylistWithoutName() {
        Playlist requestPlaylist = requestBuilder("", "New playlist description", false);

        Response response = PlayListApi.post(requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(400));

        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        assertThat(errorResponse.getStatus(), equalTo(400));
        assertThat(errorResponse.getMessage(), equalTo("Missing required field: name"));
    }
    @Test(description = "Verifying a invalid token response")
    public void testCreatePlaylistUsingInvalidToken() {
        Playlist requestPlaylist = requestBuilder("New PlayList", "New playlist description", false);

        Response response = PlayListApi.post("123" ,requestPlaylist);
        assertThat(response.getStatusCode(), equalTo(401));

        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        assertThat(errorResponse.getStatus(), equalTo(401));
        assertThat(errorResponse.getMessage(), equalTo("Invalid access token"));
    }

    @Step
    public Playlist requestBuilder(String name, String description, boolean visibility){
        return Playlist.builder()
                .name(name)
                .description(description)
                ._public(visibility)
                .build();
    }
}
