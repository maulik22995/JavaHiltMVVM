
package com.example.myapplication.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content implements Parcelable {

    @SerializedName("mediaId")
    @Expose
    private Integer mediaId;
    @SerializedName("mediaUrl")
    @Expose
    private String mediaUrl;
    @SerializedName("mediaUrlBig")
    @Expose
    private String mediaUrlBig;
    @SerializedName("mediaType")
    @Expose
    private String mediaType;
    @SerializedName("mediaDate")
    @Expose
    private MediaDate mediaDate;
    @SerializedName("mediaTitleCustom")
    @Expose
    private String mediaTitleCustom;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrlBig() {
        return mediaUrlBig;
    }

    public void setMediaUrlBig(String mediaUrlBig) {
        this.mediaUrlBig = mediaUrlBig;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public MediaDate getMediaDate() {
        return mediaDate;
    }

    public void setMediaDate(MediaDate mediaDate) {
        this.mediaDate = mediaDate;
    }

    public String getMediaTitleCustom() {
        return mediaTitleCustom;
    }

    public void setMediaTitleCustom(String mediaTitleCustom) {
        this.mediaTitleCustom = mediaTitleCustom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
