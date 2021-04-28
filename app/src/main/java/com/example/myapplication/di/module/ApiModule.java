package com.example.myapplication.di.module;

import com.example.myapplication.data.webservice.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {

    @Provides
    @Singleton
    ApiInterface provideApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
}
