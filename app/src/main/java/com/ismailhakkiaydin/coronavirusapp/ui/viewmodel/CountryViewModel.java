package com.ismailhakkiaydin.coronavirusapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {


    private CountryRepository countryRepository;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryRepository  = new CountryRepository();
    }

    public LiveData<List<Country>> getAllCountry(){
        return countryRepository.getMutableLiveData();
    }

}
