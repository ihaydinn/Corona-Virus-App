package com.ismailhakkiaydin.coronavirusapp.di.module;

import com.ismailhakkiaydin.coronavirusapp.di.module.ViewModelModule;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ServiceModule {

    public static final String BASE_URL = "https://coronavirus-monitor.p.rapidapi.com/coronavirus/";


    @Singleton
    @Provides
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
    }


    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
