
package com.pf.justwatch.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JustWatchMovies {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("page_size")
    @Expose
    private Integer pageSize;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

	@Override
	public String toString() {
		return "JustWatchMovies [page=" + page + ", pageSize=" + pageSize + ", totalPages=" + totalPages
				+ ", totalResults=" + totalResults + ", items=" + items + "]";
	}

}
