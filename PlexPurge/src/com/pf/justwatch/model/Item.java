
package com.pf.justwatch.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("full_path")
    @Expose
    private String fullPath;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("original_release_year")
    @Expose
    private Integer originalReleaseYear;
    @SerializedName("tmdb_popularity")
    @Expose
    private Double tmdbPopularity;
    @SerializedName("object_type")
    @Expose
    private String objectType;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("all_titles")
    @Expose
    private Object allTitles;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;
    @SerializedName("clips")
    @Expose
    private Object clips;
    @SerializedName("scoring")
    @Expose
    private List<Scoring> scoring = null;
    @SerializedName("credits")
    @Expose
    private Object credits;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("genre_ids")
    @Expose
    private Object genreIds;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("age_certification")
    @Expose
    private String ageCertification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getOriginalReleaseYear() {
        return originalReleaseYear;
    }

    public void setOriginalReleaseYear(Integer originalReleaseYear) {
        this.originalReleaseYear = originalReleaseYear;
    }

    public Double getTmdbPopularity() {
        return tmdbPopularity;
    }

    public void setTmdbPopularity(Double tmdbPopularity) {
        this.tmdbPopularity = tmdbPopularity;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Object getAllTitles() {
        return allTitles;
    }

    public void setAllTitles(Object allTitles) {
        this.allTitles = allTitles;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Object getClips() {
        return clips;
    }

    public void setClips(Object clips) {
        this.clips = clips;
    }

    public List<Scoring> getScoring() {
        return scoring;
    }

    public void setScoring(List<Scoring> scoring) {
        this.scoring = scoring;
    }

    public Object getCredits() {
        return credits;
    }

    public void setCredits(Object credits) {
        this.credits = credits;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Object getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(Object genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getAgeCertification() {
        return ageCertification;
    }

    public void setAgeCertification(String ageCertification) {
        this.ageCertification = ageCertification;
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", fullPath=" + fullPath + ", poster=" + poster
				+ ", shortDescription=" + shortDescription + ", originalReleaseYear=" + originalReleaseYear
				+ ", tmdbPopularity=" + tmdbPopularity + ", objectType=" + objectType + ", originalTitle="
				+ originalTitle + ", allTitles=" + allTitles + ", offers=" + offers + ", clips=" + clips + ", scoring="
				+ scoring + ", credits=" + credits + ", originalLanguage=" + originalLanguage + ", genreIds=" + genreIds
				+ ", runtime=" + runtime + ", ageCertification=" + ageCertification + "]";
	}

}
