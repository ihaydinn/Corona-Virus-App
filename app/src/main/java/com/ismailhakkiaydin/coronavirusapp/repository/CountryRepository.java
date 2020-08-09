package com.ismailhakkiaydin.coronavirusapp.repository;

import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class CountryRepository {


    private ApiService apiService;

    @Inject
    public CountryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Call<CountryResponse> modelCountry() {
        return apiService.getCountry();
    }

}
