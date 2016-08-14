
package com.pf.guidebox.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Facebook {

    @SerializedName("facebook_id")
    @Expose
    private Long facebookId;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * 
     * @return
     *     The facebookId
     */
    public Long getFacebookId() {
        return facebookId;
    }

    /**
     * 
     * @param facebookId
     *     The facebook_id
     */
    public void setFacebookId(Long facebookId) {
        this.facebookId = facebookId;
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

}
