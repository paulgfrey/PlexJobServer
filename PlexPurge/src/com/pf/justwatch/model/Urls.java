
package com.pf.justwatch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("standard_web")
    @Expose
    private String standardWeb;
    @SerializedName("deeplink_android")
    @Expose
    private String deeplinkAndroid;
    @SerializedName("deeplink_ios")
    @Expose
    private String deeplinkIos;

    public String getStandardWeb() {
        return standardWeb;
    }

    public void setStandardWeb(String standardWeb) {
        this.standardWeb = standardWeb;
    }

    public String getDeeplinkAndroid() {
        return deeplinkAndroid;
    }

    public void setDeeplinkAndroid(String deeplinkAndroid) {
        this.deeplinkAndroid = deeplinkAndroid;
    }

    public String getDeeplinkIos() {
        return deeplinkIos;
    }

    public void setDeeplinkIos(String deeplinkIos) {
        this.deeplinkIos = deeplinkIos;
    }

	@Override
	public String toString() {
		return "Urls [standardWeb=" + standardWeb + ", deeplinkAndroid=" + deeplinkAndroid + ", deeplinkIos="
				+ deeplinkIos + "]";
	}

}
