
package com.example.myapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PressReleaseModel {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("content")
    @Expose
    private List<Content> content = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
