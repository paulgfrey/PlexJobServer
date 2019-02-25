
package com.pf.plexjobserver.radarr.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "year",
    "tmdbId",
    "imdbId"
})
public class RemoteMovie {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    private String title;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("tmdbId")
    private Integer tmdbId;
    @JsonProperty("imdbId")
    private String imdbId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("tmdbId")
    public Integer getTmdbId() {
        return tmdbId;
    }

    @JsonProperty("tmdbId")
    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    @JsonProperty("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbId")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "RemoteMovie [title=" + title + ", year=" + year + ", tmdbId=" + tmdbId + ", imdbId=" + imdbId
				+ ", additionalProperties=" + additionalProperties + "]";
	}
    
    

}
