
package com.pf.guidebox.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OtherSources {

    @SerializedName("tv_on_demand")
    @Expose
    private List<TvOnDemand> tvOnDemand = new ArrayList<TvOnDemand>();

    /**
     * 
     * @return
     *     The tvOnDemand
     */
    public List<TvOnDemand> getTvOnDemand() {
        return tvOnDemand;
    }

    /**
     * 
     * @param tvOnDemand
     *     The tv_on_demand
     */
    public void setTvOnDemand(List<TvOnDemand> tvOnDemand) {
        this.tvOnDemand = tvOnDemand;
    }

}
