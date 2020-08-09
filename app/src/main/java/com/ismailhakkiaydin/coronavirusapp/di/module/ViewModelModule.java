package com.ismailhakkiaydin.coronavirusapp.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ismailhakkiaydin.coronavirusapp.di.ViewModelFactory;
import com.ismailhakkiaydin.coronavirusapp.di.key.ViewModelKey;
import com.ismailhakkiaydin.coronavirusapp.ui.viewmodel.CountryViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountryViewModel.class)
    abstract ViewModel bindViewModel(CountryViewModel countryViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}
