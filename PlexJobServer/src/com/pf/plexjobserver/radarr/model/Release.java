
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
    "quality",
    "qualityVersion",
    "releaseGroup",
    "releaseTitle",
    "indexer",
    "size"
})
public class Release {

    @JsonProperty("quality")
    private String quality;
    @JsonProperty("qualityVersion")
    private Integer qualityVersion;
    @JsonProperty("releaseGroup")
    private String releaseGroup;
    @JsonProperty("releaseTitle")
    private String releaseTitle;
    @JsonProperty("indexer")
    private String indexer;
    @JsonProperty("size")
    private Integer size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("releaseTitle")
    public String getReleaseTitle() {
        return releaseTitle;
    }

    @JsonProperty("releaseTitle")
    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    @JsonProperty("indexer")
    public String getIndexer() {
        return indexer;
    }

    @JsonProperty("indexer")
    public void setIndexer(String indexer) {
        this.indexer = indexer;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
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
		return "Release [quality=" + quality + ", qualityVersion=" + qualityVersion + ", releaseGroup=" + releaseGroup
				+ ", releaseTitle=" + releaseTitle + ", indexer=" + indexer + ", size=" + size
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
