package com.example.myapplication.data.webservice;

import com.example.myapplication.data.model.Content;
import com.example.myapplication.data.model.PressReleaseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getPressReleasesDocs")
    Call<PressReleaseModel> getPressRelease();
}
