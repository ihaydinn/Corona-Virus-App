package com.ismailhakkiaydin.coronavirusapp.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.repository.CountryRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {

    private CountryRepository mCountryRepository;
    private final MutableLiveData<CountryResponse> modelMutableLiveData = new MutableLiveData<>();

    @Inject
    public CountryViewModel(CountryRepository mCountryRepository) {
        this.mCountryRepository = mCountryRepository;
    }


    public MutableLiveData<CountryResponse> getModelMutableLiveData() {
        mCountryRepository.modelCountry().enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                CountryResponse countryResponse = response.body();
                getModelMutableLiveData().setValue(countryResponse);
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });
        return modelMutableLiveData;
    }


}
