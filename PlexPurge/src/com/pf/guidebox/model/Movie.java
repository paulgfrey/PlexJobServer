
package com.pf.guidebox.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Movie {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("release_year")
    @Expose
    private Long releaseYear;
    @SerializedName("themoviedb")
    @Expose
    private Long themoviedb;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("alternate_titles")
    @Expose
    private List<String> alternateTitles = new ArrayList<String>();
    @SerializedName("imdb")
    @Expose
    private String imdb;
    @SerializedName("pre_order")
    @Expose
    private Boolean preOrder;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rottentomatoes")
    @Expose
    private Long rottentomatoes;
    @SerializedName("freebase")
    @Expose
    private String freebase;
    @SerializedName("wikipedia_id")
    @Expose
    private Long wikipediaId;
    @SerializedName("metacritic")
    @Expose
    private String metacritic;
    @SerializedName("common_sense_media")
    @Expose
    private Object commonSenseMedia;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_120x171")
    @Expose
    private String poster120x171;
    @SerializedName("poster_240x342")
    @Expose
    private String poster240x342;
    @SerializedName("poster_400x570")
    @Expose
    private String poster400x570;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<Genre>();
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("duration")
    @Expose
    private Long duration;
    @SerializedName("trailers")
    @Expose
    private Trailers trailers;
    @SerializedName("writers")
    @Expose
    private List<Writer> writers = new ArrayList<Writer>();
    @SerializedName("directors")
    @Expose
    private List<Director> directors = new ArrayList<Director>();
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = new ArrayList<Cast>();
    @SerializedName("free_web_sources")
    @Expose
    private List<Object> freeWebSources = new ArrayList<Object>();
    @SerializedName("free_ios_sources")
    @Expose
    private List<Object> freeIosSources = new ArrayList<Object>();
    @SerializedName("free_android_sources")
    @Expose
    private List<Object> freeAndroidSources = new ArrayList<Object>();
    @SerializedName("tv_everywhere_web_sources")
    @Expose
    private List<TvEverywhereWebSource> tvEverywhereWebSources = new ArrayList<TvEverywhereWebSource>();
    @SerializedName("tv_everywhere_ios_sources")
    @Expose
    private List<TvEverywhereIosSource> tvEverywhereIosSources = new ArrayList<TvEverywhereIosSource>();
    @SerializedName("tv_everywhere_android_sources")
    @Expose
    private List<TvEverywhereAndroidSource> tvEverywhereAndroidSources = new ArrayList<TvEverywhereAndroidSource>();
    @SerializedName("subscription_web_sources")
    @Expose
    private List<SubscriptionWebSource> subscriptionWebSources = new ArrayList<SubscriptionWebSource>();
    @SerializedName("subscription_ios_sources")
    @Expose
    private List<SubscriptionIosSource> subscriptionIosSources = new ArrayList<SubscriptionIosSource>();
    @SerializedName("subscription_android_sources")
    @Expose
    private List<SubscriptionAndroidSource> subscriptionAndroidSources = new ArrayList<SubscriptionAndroidSource>();
    @SerializedName("purchase_web_sources")
    @Expose
    private List<PurchaseWebSource> purchaseWebSources = new ArrayList<PurchaseWebSource>();
    @SerializedName("purchase_ios_sources")
    @Expose
    private List<PurchaseIosSource> purchaseIosSources = new ArrayList<PurchaseIosSource>();
    @SerializedName("purchase_android_sources")
    @Expose
    private List<PurchaseAndroidSource> purchaseAndroidSources = new ArrayList<PurchaseAndroidSource>();
    @SerializedName("other_sources")
    @Expose
    private transient List<OtherSources> otherSources;

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
     *     The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * 
     * @param overview
     *     The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
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

    /**
     * 
     * @return
     *     The social
     */
    public Social getSocial() {
        return social;
    }

    /**
     * 
     * @param social
     *     The social
     */
    public void setSocial(Social social) {
        this.social = social;
    }

    /**
     * 
     * @return
     *     The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The trailers
     */
    public Trailers getTrailers() {
        return trailers;
    }

    /**
     * 
     * @param trailers
     *     The trailers
     */
    public void setTrailers(Trailers trailers) {
        this.trailers = trailers;
    }

    /**
     * 
     * @return
     *     The writers
     */
    public List<Writer> getWriters() {
        return writers;
    }

    /**
     * 
     * @param writers
     *     The writers
     */
    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    /**
     * 
     * @return
     *     The directors
     */
    public List<Director> getDirectors() {
        return directors;
    }

    /**
     * 
     * @param directors
     *     The directors
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    /**
     * 
     * @return
     *     The cast
     */
    public List<Cast> getCast() {
        return cast;
    }

    /**
     * 
     * @param cast
     *     The cast
     */
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    /**
     * 
     * @return
     *     The freeWebSources
     */
    public List<Object> getFreeWebSources() {
        return freeWebSources;
    }

    /**
     * 
     * @param freeWebSources
     *     The free_web_sources
     */
    public void setFreeWebSources(List<Object> freeWebSources) {
        this.freeWebSources = freeWebSources;
    }

    /**
     * 
     * @return
     *     The freeIosSources
     */
    public List<Object> getFreeIosSources() {
        return freeIosSources;
    }

    /**
     * 
     * @param freeIosSources
     *     The free_ios_sources
     */
    public void setFreeIosSources(List<Object> freeIosSources) {
        this.freeIosSources = freeIosSources;
    }

    /**
     * 
     * @return
     *     The freeAndroidSources
     */
    public List<Object> getFreeAndroidSources() {
        return freeAndroidSources;
    }

    /**
     * 
     * @param freeAndroidSources
     *     The free_android_sources
     */
    public void setFreeAndroidSources(List<Object> freeAndroidSources) {
        this.freeAndroidSources = freeAndroidSources;
    }

    /**
     * 
     * @return
     *     The tvEverywhereWebSources
     */
    public List<TvEverywhereWebSource> getTvEverywhereWebSources() {
        return tvEverywhereWebSources;
    }

    /**
     * 
     * @param tvEverywhereWebSources
     *     The tv_everywhere_web_sources
     */
    public void setTvEverywhereWebSources(List<TvEverywhereWebSource> tvEverywhereWebSources) {
        this.tvEverywhereWebSources = tvEverywhereWebSources;
    }

    /**
     * 
     * @return
     *     The tvEverywhereIosSources
     */
    public List<TvEverywhereIosSource> getTvEverywhereIosSources() {
        return tvEverywhereIosSources;
    }

    /**
     * 
     * @param tvEverywhereIosSources
     *     The tv_everywhere_ios_sources
     */
    public void setTvEverywhereIosSources(List<TvEverywhereIosSource> tvEverywhereIosSources) {
        this.tvEverywhereIosSources = tvEverywhereIosSources;
    }

    /**
     * 
     * @return
     *     The tvEverywhereAndroidSources
     */
    public List<TvEverywhereAndroidSource> getTvEverywhereAndroidSources() {
        return tvEverywhereAndroidSources;
    }

    /**
     * 
     * @param tvEverywhereAndroidSources
     *     The tv_everywhere_android_sources
     */
    public void setTvEverywhereAndroidSources(List<TvEverywhereAndroidSource> tvEverywhereAndroidSources) {
        this.tvEverywhereAndroidSources = tvEverywhereAndroidSources;
    }

    /**
     * 
     * @return
     *     The subscriptionWebSources
     */
    public List<SubscriptionWebSource> getSubscriptionWebSources() {
        return subscriptionWebSources;
    }

    /**
     * 
     * @param subscriptionWebSources
     *     The subscription_web_sources
     */
    public void setSubscriptionWebSources(List<SubscriptionWebSource> subscriptionWebSources) {
        this.subscriptionWebSources = subscriptionWebSources;
    }

    /**
     * 
     * @return
     *     The subscriptionIosSources
     */
    public List<SubscriptionIosSource> getSubscriptionIosSources() {
        return subscriptionIosSources;
    }

    /**
     * 
     * @param subscriptionIosSources
     *     The subscription_ios_sources
     */
    public void setSubscriptionIosSources(List<SubscriptionIosSource> subscriptionIosSources) {
        this.subscriptionIosSources = subscriptionIosSources;
    }

    /**
     * 
     * @return
     *     The subscriptionAndroidSources
     */
    public List<SubscriptionAndroidSource> getSubscriptionAndroidSources() {
        return subscriptionAndroidSources;
    }

    /**
     * 
     * @param subscriptionAndroidSources
     *     The subscription_android_sources
     */
    public void setSubscriptionAndroidSources(List<SubscriptionAndroidSource> subscriptionAndroidSources) {
        this.subscriptionAndroidSources = subscriptionAndroidSources;
    }

    /**
     * 
     * @return
     *     The purchaseWebSources
     */
    public List<PurchaseWebSource> getPurchaseWebSources() {
        return purchaseWebSources;
    }

    /**
     * 
     * @param purchaseWebSources
     *     The purchase_web_sources
     */
    public void setPurchaseWebSources(List<PurchaseWebSource> purchaseWebSources) {
        this.purchaseWebSources = purchaseWebSources;
    }

    /**
     * 
     * @return
     *     The purchaseIosSources
     */
    public List<PurchaseIosSource> getPurchaseIosSources() {
        return purchaseIosSources;
    }

    /**
     * 
     * @param purchaseIosSources
     *     The purchase_ios_sources
     */
    public void setPurchaseIosSources(List<PurchaseIosSource> purchaseIosSources) {
        this.purchaseIosSources = purchaseIosSources;
    }

    /**
     * 
     * @return
     *     The purchaseAndroidSources
     */
    public List<PurchaseAndroidSource> getPurchaseAndroidSources() {
        return purchaseAndroidSources;
    }

    /**
     * 
     * @param purchaseAndroidSources
     *     The purchase_android_sources
     */
    public void setPurchaseAndroidSources(List<PurchaseAndroidSource> purchaseAndroidSources) {
        this.purchaseAndroidSources = purchaseAndroidSources;
    }

    /**
     * 
     * @return
     *     The otherSources
     */
    public List<OtherSources> getOtherSources() {
        return otherSources;
    }

    /**
     * 
     * @param otherSources
     *     The other_sources
     */
    public void setOtherSources(List<OtherSources> otherSources) {
        this.otherSources = otherSources;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }   
}
