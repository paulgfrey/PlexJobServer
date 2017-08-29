
package com.pf.justwatch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scoring {

    @SerializedName("provider_type")
    @Expose
    private String providerType;
    @SerializedName("value")
    @Expose
    private Float value;

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

	@Override
	public String toString() {
		return "Scoring [providerType=" + providerType + ", value=" + value + "]";
	}

}
