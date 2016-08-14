
package com.pf.guidebox.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TvOnDemand {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_type")
    @Expose
    private String sourceType;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("formats")
    @Expose
    private List<Format___> formats = new ArrayList<Format___>();

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
     *     The sourceType
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 
     * @param sourceType
     *     The source_type
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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
     *     The platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 
     * @param platform
     *     The platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 
     * @return
     *     The formats
     */
    public List<Format___> getFormats() {
        return formats;
    }

    /**
     * 
     * @param formats
     *     The formats
     */
    public void setFormats(List<Format___> formats) {
        this.formats = formats;
    }

}
