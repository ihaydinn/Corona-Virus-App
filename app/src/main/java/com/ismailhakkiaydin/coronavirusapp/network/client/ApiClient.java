package com.ismailhakkiaydin.coronavirusapp.network.client;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://coronavirus-monitor.p.rapidapi.com/coronavirus/";


    public static Retrofit retrofit;

/*
    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Request newRequest = request.newBuilder()
                            .addHeader("x-rapidapi-key", "b952aa037bmsh7ecbf0f6bcabe58p1ff1e8jsndfddd40f88e0")
                            .build();
                    return chain.proceed(newRequest);
                }
            });

*/
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            return retrofit;
        }
        return retrofit;
    }
}


