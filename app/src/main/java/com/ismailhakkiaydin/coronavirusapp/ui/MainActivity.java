package com.ismailhakkiaydin.coronavirusapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.CountryAdapter;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.ItemClickListener;
import com.ismailhakkiaydin.coronavirusapp.ui.viewmodel.CountryViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MainActivity extends AppCompatActivity implements HasAndroidInjector {

    private CountryAdapter countryAdapter;
    private List<Country> countryList;

    @Inject
    DispatchingAndroidInjector<Object> fragmentDispatchingAndroidInjector;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private CountryViewModel countryViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final SwipeRefreshLayout mSwipeRefreshLayout = activityMainBinding.swipeRefreshLayout;

        RecyclerView recyclerView = activityMainBinding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        countryViewModel = ViewModelProviders.of(this, viewModelFactory).get(CountryViewModel.class);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                R.color.colorPrimary);

        /*
        countryViewModel.getModelMutableLiveData().observe(this, new Observer<CountryResponse>() {
            @Override
            public void onChanged(CountryResponse countryResponse) {
                countryAdapter.setCountryList(countryResponse.getCountriesStat());
            }
        });*/

        countryViewModel.getAllCountries(this);
        countryViewModel.getModelMutableLiveData().observe(this, new Observer<CountryResponse>() {
            @Override
            public void onChanged(CountryResponse countryResponse) {
                countryAdapter.setCountryList(countryResponse.getCountriesStat());
            }
        });


        countryAdapter = new CountryAdapter(this, countryList, new ItemClickListener() {
            @Override
            public void onItemClick(Country country, int position) {
                CountryDialog countryDialog = new CountryDialog();
                Bundle bundle = new Bundle();
                bundle.putParcelable("country_detail", country);
                countryDialog.setArguments(bundle);
                countryDialog.show(getSupportFragmentManager(), "Country Dialog");

            }
        });
        recyclerView.setAdapter(countryAdapter);

    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return fragmentDispatchingAndroidInjector;
    }


}
