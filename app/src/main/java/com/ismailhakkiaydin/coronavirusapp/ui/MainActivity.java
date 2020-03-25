package com.ismailhakkiaydin.coronavirusapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.coronavirusapp.databinding.CountryDialogBoxBinding;
import com.ismailhakkiaydin.coronavirusapp.databinding.CountryListItemBinding;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiClient;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.CountryAdapter;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.ItemClickListener;
import com.ismailhakkiaydin.coronavirusapp.ui.viewmodel.CountryViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private List<Country> countryList;
    private RecyclerView recyclerView;
    private CountryViewModel countryViewModel;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final SwipeRefreshLayout mSwipeRefreshLayout = activityMainBinding.swipeRefreshLayout;
        RecyclerView recyclerView = activityMainBinding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                R.color.colorPrimary);


        recyclerViewLayout();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewLayout();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
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

    private void recyclerViewLayout() {
        countryViewModel.getAllCountry().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setCountryList(countries);
            }
        });
    }

}
