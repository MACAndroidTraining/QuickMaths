
package com.example.admin.quickmaths.model.WalmartSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WalmartSearch implements Serializable{

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("responseGroup")
    @Expose
    private String responseGroup;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("numItems")
    @Expose
    private Integer numItems;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("facets")
    @Expose
    private List<Object> facets = null;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getResponseGroup() {
        return responseGroup;
    }

    public void setResponseGroup(String responseGroup) {
        this.responseGroup = responseGroup;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNumItems() {
        return numItems;
    }

    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Object> getFacets() {
        return facets;
    }

    public void setFacets(List<Object> facets) {
        this.facets = facets;
    }

}
