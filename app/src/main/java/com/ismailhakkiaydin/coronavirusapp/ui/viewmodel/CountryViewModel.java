package com.ismailhakkiaydin.coronavirusapp.ui.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.repository.CountryRepository;

import javax.inject.Inject;

public class CountryViewModel extends ViewModel {

    private CountryRepository mCountryRepository;
    private final MutableLiveData<CountryResponse> modelMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<CountryResponse> getModelMutableLiveData() {
        return modelMutableLiveData;
    }

    @Inject
    public CountryViewModel(CountryRepository mCountryRepository) {
        this.mCountryRepository = mCountryRepository;
    }

/*
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
    }*/

    public void getAllCountries(LifecycleOwner lifecycleOwner) {
        mCountryRepository.getCountryList().observe(lifecycleOwner, new Observer<CountryResponse>() {
            @Override
            public void onChanged(CountryResponse countryResponseResource) {
            modelMutableLiveData.setValue(countryResponseResource);
            }
        });
    }


}
