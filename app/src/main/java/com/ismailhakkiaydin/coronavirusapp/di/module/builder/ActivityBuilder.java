package com.ismailhakkiaydin.coronavirusapp.di.module.builder;

import com.ismailhakkiaydin.coronavirusapp.di.scope.ActivityScope;
import com.ismailhakkiaydin.coronavirusapp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

}
