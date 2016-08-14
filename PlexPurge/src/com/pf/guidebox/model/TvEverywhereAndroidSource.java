
package com.pf.guidebox.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TvEverywhereAndroidSource {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("tv_channel")
    @Expose
    private String tvChannel;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("app_link")
    @Expose
    private Long appLink;
    @SerializedName("app_required")
    @Expose
    private Long appRequired;
    @SerializedName("app_download_link")
    @Expose
    private String appDownloadLink;

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The tvChannel
     */
    public String getTvChannel() {
        return tvChannel;
    }

    /**
     * 
     * @param tvChannel
     *     The tv_channel
     */
    public void setTvChannel(String tvChannel) {
        this.tvChannel = tvChannel;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 
     * @param appName
     *     The app_name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 
     * @return
     *     The appLink
     */
    public Long getAppLink() {
        return appLink;
    }

    /**
     * 
     * @param appLink
     *     The app_link
     */
    public void setAppLink(Long appLink) {
        this.appLink = appLink;
    }

    /**
     * 
     * @return
     *     The appRequired
     */
    public Long getAppRequired() {
        return appRequired;
    }

    /**
     * 
     * @param appRequired
     *     The app_required
     */
    public void setAppRequired(Long appRequired) {
        this.appRequired = appRequired;
    }

    /**
     * 
     * @return
     *     The appDownloadLink
     */
    public String getAppDownloadLink() {
        return appDownloadLink;
    }

    /**
     * 
     * @param appDownloadLink
     *     The app_download_link
     */
    public void setAppDownloadLink(String appDownloadLink) {
        this.appDownloadLink = appDownloadLink;
    }

}
