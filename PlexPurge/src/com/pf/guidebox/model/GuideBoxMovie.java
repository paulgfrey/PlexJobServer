
package com.pf.guidebox.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Generated("org.jsonschema2pojo")
public class GuideBoxMovie {

    private Long id;
    private String title;
    private Long releaseYear;
    private Long themoviedb;
    private String originalTitle;
    private List<String> alternateTitles = new ArrayList<String>();
    private String imdb;
    private Boolean preOrder;
    private String releaseDate;
    private String rating;
    private Long rottentomatoes;
    private String freebase;
    private Long wikipediaId;
    private String metacritic;
    private Object commonSenseMedia;
    private String poster120x171;
    private String poster240x342;
    private String poster400x570;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Long id) {
        this.id = id;
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
     *     The releaseYear
     */
    public Long getReleaseYear() {
        return releaseYear;
    }

    /**
     * 
     * @param releaseYear
     *     The release_year
     */
    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * 
     * @return
     *     The themoviedb
     */
    public Long getThemoviedb() {
        return themoviedb;
    }

    /**
     * 
     * @param themoviedb
     *     The themoviedb
     */
    public void setThemoviedb(Long themoviedb) {
        this.themoviedb = themoviedb;
    }

    /**
     * 
     * @return
     *     The originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * 
     * @param originalTitle
     *     The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * 
     * @return
     *     The alternateTitles
     */
    public List<String> getAlternateTitles() {
        return alternateTitles;
    }

    /**
     * 
     * @param alternateTitles
     *     The alternate_titles
     */
    public void setAlternateTitles(List<String> alternateTitles) {
        this.alternateTitles = alternateTitles;
    }

    /**
     * 
     * @return
     *     The imdb
     */
    public String getImdb() {
        return imdb;
    }

    /**
     * 
     * @param imdb
     *     The imdb
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    /**
     * 
     * @return
     *     The preOrder
     */
    public Boolean getPreOrder() {
        return preOrder;
    }

    /**
     * 
     * @param preOrder
     *     The pre_order
     */
    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    /**
     * 
     * @return
     *     The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     *     The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The rottentomatoes
     */
    public Long getRottentomatoes() {
        return rottentomatoes;
    }

    /**
     * 
     * @param rottentomatoes
     *     The rottentomatoes
     */
    public void setRottentomatoes(Long rottentomatoes) {
        this.rottentomatoes = rottentomatoes;
    }

    /**
     * 
     * @return
     *     The freebase
     */
    public String getFreebase() {
        return freebase;
    }

    /**
     * 
     * @param freebase
     *     The freebase
     */
    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    /**
     * 
     * @return
     *     The wikipediaId
     */
    public Long getWikipediaId() {
        return wikipediaId;
    }

    /**
     * 
     * @param wikipediaId
     *     The wikipedia_id
     */
    public void setWikipediaId(Long wikipediaId) {
        this.wikipediaId = wikipediaId;
    }

    /**
     * 
     * @return
     *     The metacritic
     */
    public String getMetacritic() {
        return metacritic;
    }

    /**
     * 
     * @param metacritic
     *     The metacritic
     */
    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }

    /**
     * 
     * @return
     *     The commonSenseMedia
     */
    public Object getCommonSenseMedia() {
        return commonSenseMedia;
    }

    /**
     * 
     * @param commonSenseMedia
     *     The common_sense_media
     */
    public void setCommonSenseMedia(Object commonSenseMedia) {
        this.commonSenseMedia = commonSenseMedia;
    }

    /**
     * 
     * @return
     *     The poster120x171
     */
    public String getPoster120x171() {
        return poster120x171;
    }

    /**
     * 
     * @param poster120x171
     *     The poster_120x171
     */
    public void setPoster120x171(String poster120x171) {
        this.poster120x171 = poster120x171;
    }

    /**
     * 
     * @return
     *     The poster240x342
     */
    public String getPoster240x342() {
        return poster240x342;
    }

    /**
     * 
     * @param poster240x342
     *     The poster_240x342
     */
    public void setPoster240x342(String poster240x342) {
        this.poster240x342 = poster240x342;
    }

    /**
     * 
     * @return
     *     The poster400x570
     */
    public String getPoster400x570() {
        return poster400x570;
    }

    /**
     * 
     * @param poster400x570
     *     The poster_400x570
     */
    public void setPoster400x570(String poster400x570) {
        this.poster400x570 = poster400x570;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }   
}
