
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
    "id",
    "relativePath",
    "path",
    "quality",
    "qualityVersion",
    "releaseGroup",
    "sceneName"
})
public class MovieFile {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("relativePath")
    private String relativePath;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    private String path;
    @JsonProperty("quality")
    private String quality;
    @JsonProperty("qualityVersion")
    private Integer qualityVersion;
    @JsonProperty("releaseGroup")
    private String releaseGroup;
    @JsonProperty("sceneName")
    private String sceneName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("relativePath")
    public String getRelativePath() {
        return relativePath;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("relativePath")
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("qualityVersion")
    public Integer getQualityVersion() {
        return qualityVersion;
    }

    @JsonProperty("qualityVersion")
    public void setQualityVersion(Integer qualityVersion) {
        this.qualityVersion = qualityVersion;
    }

    @JsonProperty("releaseGroup")
    public String getReleaseGroup() {
        return releaseGroup;
    }

    @JsonProperty("releaseGroup")
    public void setReleaseGroup(String releaseGroup) {
        this.releaseGroup = releaseGroup;
    }

    @JsonProperty("sceneName")
    public String getSceneName() {
        return sceneName;
    }

    @JsonProperty("sceneName")
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
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
		return "MovieFile [id=" + id + ", relativePath=" + relativePath + ", path=" + path + ", quality=" + quality
				+ ", qualityVersion=" + qualityVersion + ", releaseGroup=" + releaseGroup + ", sceneName=" + sceneName
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
