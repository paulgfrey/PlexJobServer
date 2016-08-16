
package com.pf.canistreamit.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links {

    private String rottentomatoes;
    private String shortUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The rottentomatoes
     */
    public String getRottentomatoes() {
        return rottentomatoes;
    }

    /**
     * 
     * @param rottentomatoes
     *     The rottentomatoes
     */
    public void setRottentomatoes(String rottentomatoes) {
        this.rottentomatoes = rottentomatoes;
    }

    /**
     * 
     * @return
     *     The shortUrl
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * 
     * @param shortUrl
     *     The shortUrl
     */
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Links [rottentomatoes=" + rottentomatoes + ", shortUrl=" + shortUrl + ", additionalProperties="
				+ additionalProperties + "]";
	}

}
