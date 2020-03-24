package com.ismailhakkiaydin.coronavirusapp.repository;

import androidx.lifecycle.MutableLiveData;

import com.ismailhakkiaydin.coronavirusapp.network.client.ApiClient;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.CountryAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {

    private ApiService apiService;
    private List<Country> mCountryList = new ArrayList<>();
    private MutableLiveData<List<Country>> mutableLiveData = new MutableLiveData<>();

    public CountryRepository(){}

    public MutableLiveData<List<Country>> getMutableLiveData(){

        apiService = ApiClient.getClient().create(ApiService.class);
        Call<CountryResponse> call = apiService.getCountry();
        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse countryResponse = response.body();
                mCountryList = countryResponse.getCountriesStat();
                mutableLiveData.setValue(mCountryList);
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }

}
