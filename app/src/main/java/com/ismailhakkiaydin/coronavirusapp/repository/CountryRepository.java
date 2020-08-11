package com.ismailhakkiaydin.coronavirusapp.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;
import com.ismailhakkiaydin.coronavirusapp.network.client.data.NetworkBoundResource;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;

import javax.inject.Inject;

import retrofit2.Call;

public class CountryRepository {


    private ApiService apiService;

    @Inject
    public CountryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /*
    public Call<CountryResponse> modelCountry() {
        return apiService.getCountry();
    }
*/
    public LiveData<CountryResponse> getCountryList() {
        return new NetworkBoundResource<CountryResponse>() {


            @NonNull
            @Override
            protected Call<CountryResponse> createCall() {
                return apiService.getCountry();
            }

            @Override
            protected void onFetchFailed() {
                super.onFetchFailed();
            }
        }.getResultData();

    }
}
