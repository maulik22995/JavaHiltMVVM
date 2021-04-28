package com.example.myapplication.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    private static  String BASE_URL = "https://www.monclergroup.com/wp-json/mobileApp/v1/";

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttp(HttpLoggingInterceptor loggingIntercepter){
        return new OkHttpClient.Builder().addInterceptor(loggingIntercepter).build();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
