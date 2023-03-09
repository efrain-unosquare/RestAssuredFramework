package org.example.spotify.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrl external_urls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Images> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("primary_color")
    private String primary_color;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshot_id;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Jacksonized
    static class ExternalUrl{
        @JsonProperty("spotify")
        private String spotify;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Jacksonized
    static class Followers {
        @JsonProperty("href")
        private String href;
        @JsonProperty("total")
        private Integer total;

    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Jacksonized
    static class Images {
        @JsonProperty("url")
        private String url;
        @JsonProperty("height")
        private Integer height;
        @JsonProperty("width")
        private Integer width;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Jacksonized
    static class Owner {
        @JsonProperty("external_urls")
        private ExternalUrl external_urls;
        @JsonProperty("followers")
        private Followers followers;
        @JsonProperty("href")
        private String href;
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("uri")
        private String uri;
        @JsonProperty("display_name")
        private String display_name;
    }
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Jacksonized
    static class Tracks {
        @JsonProperty("href")
        private String href;
        @JsonProperty("items")
        private List<Object> items;
        @JsonProperty("limit")
        private Integer limit;
        @JsonProperty("next")
        private String next;
        @JsonProperty("offset")
        private Integer offset;
        @JsonProperty("previous")
        private String previous;
        @JsonProperty("total")
        private Integer total;
    }
}
