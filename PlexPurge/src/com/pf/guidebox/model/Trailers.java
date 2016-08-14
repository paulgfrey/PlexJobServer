
package com.pf.guidebox.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Trailers {

    @SerializedName("web")
    @Expose
    private List<Web> web = new ArrayList<Web>();
    @SerializedName("ios")
    @Expose
    private List<Io> ios = new ArrayList<Io>();
    @SerializedName("android")
    @Expose
    private List<Android> android = new ArrayList<Android>();

    /**
     * 
     * @return
     *     The web
     */
    public List<Web> getWeb() {
        return web;
    }

    /**
     * 
     * @param web
     *     The web
     */
    public void setWeb(List<Web> web) {
        this.web = web;
    }

    /**
     * 
     * @return
     *     The ios
     */
    public List<Io> getIos() {
        return ios;
    }

    /**
     * 
     * @param ios
     *     The ios
     */
    public void setIos(List<Io> ios) {
        this.ios = ios;
    }

    /**
     * 
     * @return
     *     The android
     */
    public List<Android> getAndroid() {
        return android;
    }

    /**
     * 
     * @param android
     *     The android
     */
    public void setAndroid(List<Android> android) {
        this.android = android;
    }

}
