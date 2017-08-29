
package com.pf.justwatch.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("monetization_type")
    @Expose
    private String monetizationType;
    @SerializedName("provider_id")
    @Expose
    private Integer providerId;
    @SerializedName("last_change_retail_price")
    @Expose
    private Float lastChangeRetailPrice;
    @SerializedName("last_change_difference")
    @Expose
    private Float lastChangeDifference;
    @SerializedName("last_change_percent")
    @Expose
    private Float lastChangePercent;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("subtitle_languages")
    @Expose
    private List<String> subtitleLanguages = null;
    @SerializedName("audio_languages")
    @Expose
    private List<Object> audioLanguages = null;
    @SerializedName("presentation_type")
    @Expose
    private String presentationType;
    @SerializedName("date_created_provider_id")
    @Expose
    private String dateCreatedProviderId;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("retail_price")
    @Expose
    private Double retailPrice;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getMonetizationType() {
        return monetizationType;
    }

    public void setMonetizationType(String monetizationType) {
        this.monetizationType = monetizationType;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Float getLastChangeRetailPrice() {
        return lastChangeRetailPrice;
    }

    public void setLastChangeRetailPrice(Float lastChangeRetailPrice) {
        this.lastChangeRetailPrice = lastChangeRetailPrice;
    }

    public Float getLastChangeDifference() {
        return lastChangeDifference;
    }

    public void setLastChangeDifference(Float lastChangeDifference) {
        this.lastChangeDifference = lastChangeDifference;
    }

    public Float getLastChangePercent() {
        return lastChangePercent;
    }

    public void setLastChangePercent(Float lastChangePercent) {
        this.lastChangePercent = lastChangePercent;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public List<String> getSubtitleLanguages() {
        return subtitleLanguages;
    }

    public void setSubtitleLanguages(List<String> subtitleLanguages) {
        this.subtitleLanguages = subtitleLanguages;
    }

    public List<Object> getAudioLanguages() {
        return audioLanguages;
    }

    public void setAudioLanguages(List<Object> audioLanguages) {
        this.audioLanguages = audioLanguages;
    }

    public String getPresentationType() {
        return presentationType;
    }

    public void setPresentationType(String presentationType) {
        this.presentationType = presentationType;
    }

    public String getDateCreatedProviderId() {
        return dateCreatedProviderId;
    }

    public void setDateCreatedProviderId(String dateCreatedProviderId) {
        this.dateCreatedProviderId = dateCreatedProviderId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

	@Override
	public String toString() {
		return "Offer [monetizationType=" + monetizationType + ", providerId=" + providerId + ", lastChangeRetailPrice="
				+ lastChangeRetailPrice + ", lastChangeDifference=" + lastChangeDifference + ", lastChangePercent="
				+ lastChangePercent + ", urls=" + urls + ", subtitleLanguages=" + subtitleLanguages
				+ ", audioLanguages=" + audioLanguages + ", presentationType=" + presentationType
				+ ", dateCreatedProviderId=" + dateCreatedProviderId + ", dateCreated=" + dateCreated + ", country="
				+ country + ", retailPrice=" + retailPrice + ", currency=" + currency + "]";
	}

}
