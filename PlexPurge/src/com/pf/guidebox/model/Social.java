
package com.pf.guidebox.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Social {

    @SerializedName("facebook")
    @Expose
    private Facebook facebook;

    /**
     * 
     * @return
     *     The facebook
     */
    public Facebook getFacebook() {
        return facebook;
    }

    /**
     * 
     * @param facebook
     *     The facebook
     */
    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

}
