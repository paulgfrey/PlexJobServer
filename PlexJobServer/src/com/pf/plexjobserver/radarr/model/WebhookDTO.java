
package com.pf.plexjobserver.radarr.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * RadarrEvent
 * <p>
 * Radarr Webhook Event
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventType",
    "movie",
    "remoteMovie",
    "release",
    "movieFile",
    "isUpgrade"
})
public class WebhookDTO {

    @JsonProperty("eventType")
    private WebhookDTO.EventType eventType;
    @JsonProperty("movie")
    private Movie movie;
    @JsonProperty("remoteMovie")
    private RemoteMovie remoteMovie;
    @JsonProperty("release")
    private Release release;
    @JsonProperty("movieFile")
    private MovieFile movieFile;
    @JsonProperty("isUpgrade")
    private Boolean isUpgrade;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("eventType")
    public WebhookDTO.EventType getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(WebhookDTO.EventType eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("movie")
    public Movie getMovie() {
        return movie;
    }

    @JsonProperty("movie")
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @JsonProperty("remoteMovie")
    public RemoteMovie getRemoteMovie() {
        return remoteMovie;
    }

    @JsonProperty("remoteMovie")
    public void setRemoteMovie(RemoteMovie remoteMovie) {
        this.remoteMovie = remoteMovie;
    }

    @JsonProperty("release")
    public Release getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(Release release) {
        this.release = release;
    }

    @JsonProperty("movieFile")
    public MovieFile getMovieFile() {
        return movieFile;
    }

    @JsonProperty("movieFile")
    public void setMovieFile(MovieFile movieFile) {
        this.movieFile = movieFile;
    }

    @JsonProperty("isUpgrade")
    public Boolean getIsUpgrade() {
        return isUpgrade;
    }

    @JsonProperty("isUpgrade")
    public void setIsUpgrade(Boolean isUpgrade) {
        this.isUpgrade = isUpgrade;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum EventType {

        DOWNLOAD("Download"),
        GRAB("Grab"),
        RENAME("Rename"),
        TEST("Test");
        private final String value;
        private final static Map<String, WebhookDTO.EventType> CONSTANTS = new HashMap<String, WebhookDTO.EventType>();

        static {
            for (WebhookDTO.EventType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private EventType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static WebhookDTO.EventType fromValue(String value) {
            WebhookDTO.EventType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

	@Override
	public String toString() {
		return "WebhookDTO [eventType=" + eventType + ", movie=" + movie + ", remoteMovie=" + remoteMovie + ", release="
				+ release + ", movieFile=" + movieFile + ", isUpgrade=" + isUpgrade + ", additionalProperties="
				+ additionalProperties + "]";
	}
    
}
