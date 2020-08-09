package com.ismailhakkiaydin.coronavirusapp.di;

import android.app.Application;

import com.ismailhakkiaydin.coronavirusapp.App;
import com.ismailhakkiaydin.coronavirusapp.di.module.ServiceModule;
import com.ismailhakkiaydin.coronavirusapp.di.module.builder.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ServiceModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    void inject(App app);

}
