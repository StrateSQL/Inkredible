package com.printifyproject.printifyapi.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PagedImages {
    @JsonProperty("current_page")
    private int CurrentPage;

    private List<Image> Data;

    @JsonProperty("first_page_url")
    private String FirstPageUrl;

    private int From;

    @JsonProperty("last_page")
    private int LastPage;

    @JsonProperty("last_page_url")
    private String LastPageUrl;

    @JsonProperty("next_page_url")
    private String NextPageUrl;

    private String Path;

    @JsonProperty("per_page")
    private int PerPage;

    @JsonProperty("prev_page_url")
    private String PreviousPageUrl;

    private int To;

    private int Total;

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.CurrentPage = currentPage;
    }

    public List<Image> getData() {
        return Data;
    }

    public void setData(List<Image> data) {
        this.Data = data;
    }

    public String getFirstPageUrl() {
        return FirstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.FirstPageUrl = firstPageUrl;
    }

    public int getFrom() {
        return From;
    }

    public void setFrom(int from) {
        this.From = from;
    }

    public int getLastPage() {
        return LastPage;
    }

    public void setLastPage(int lastPage) {
        this.LastPage = lastPage;
    }

    public String getLastPageUrl() {
        return LastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.LastPageUrl = lastPageUrl;
    }

    public String getNextPageUrl() {
        return NextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.NextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        this.Path = path;
    }

    public int getPerPage() {
        return PerPage;
    }

    public void setPerPage(int perPage) {
        this.PerPage = perPage;
    }

    public String getPreviousPageUrl() {
        return PreviousPageUrl;
    }

    public void setPreviousPageUrl(String previousPageUrl) {
        this.PreviousPageUrl = previousPageUrl;
    }

    public int getTo() {
        return To;
    }

    public void setTo(int to) {
        this.To = to;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }
}
