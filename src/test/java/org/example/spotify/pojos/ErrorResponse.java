package org.example.spotify.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.jackson.Jacksonized;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @Delegate
    @JsonProperty("error")
    private ErrorDetails error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ErrorDetails {
        @JsonProperty("status")
        private Integer status;
        @JsonProperty("message")
        private String message;
    }
}
