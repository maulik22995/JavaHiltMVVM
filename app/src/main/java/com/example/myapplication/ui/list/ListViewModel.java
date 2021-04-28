package com.example.myapplication.ui.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.model.Content;
import com.example.myapplication.data.model.PressReleaseModel;
import com.example.myapplication.data.webservice.ApiInterface;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class ListViewModel extends ViewModel {
    MutableLiveData<PressReleaseModel> liveDataPressRelease = new MutableLiveData<>();

    @Inject
    public ListViewModel(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    private ApiInterface apiInterface;

    public void fetchData() {
        Call<PressReleaseModel> apiCall = apiInterface.getPressRelease();
        apiCall.enqueue(new Callback<PressReleaseModel>() {
            @Override
            public void onResponse(Call<PressReleaseModel> call, Response<PressReleaseModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null)
                        liveDataPressRelease.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PressReleaseModel> call, Throwable t) {

            }
        });
    }
}