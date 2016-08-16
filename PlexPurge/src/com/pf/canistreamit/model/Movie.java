
package com.pf.canistreamit.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Movie {

    private String actors;
    private Double rating;
    private Integer year;
    private String description;
    private String title;
    private String _id;
    private String image;
    private Integer imageLastUpdated;
    private Links links;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * 
     * @param actors
     *     The actors
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return _id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String _id) {
        this._id = _id;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The imageLastUpdated
     */
    public Integer getImageLastUpdated() {
        return imageLastUpdated;
    }

    /**
     * 
     * @param imageLastUpdated
     *     The image_last_updated
     */
    public void setImageLastUpdated(Integer imageLastUpdated) {
        this.imageLastUpdated = imageLastUpdated;
    }

    /**
     * 
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Movie [actors=" + actors + ", rating=" + rating + ", year=" + year + ", description=" + description
				+ ", title=" + title + ", _id=" + _id + ", image=" + image + ", imageLastUpdated=" + imageLastUpdated
				+ ", links=" + links + ", additionalProperties=" + additionalProperties + "]";
	}

}
