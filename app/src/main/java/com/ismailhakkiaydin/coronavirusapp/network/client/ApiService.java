package com.ismailhakkiaydin.coronavirusapp.network.client;

import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("x-rapidapi-key: b952aa037bmsh7ecbf0f6bcabe58p1ff1e8jsndfddd40f88e0")
    @GET("cases_by_country.php")
    Call<CountryResponse> getCountry();
}
