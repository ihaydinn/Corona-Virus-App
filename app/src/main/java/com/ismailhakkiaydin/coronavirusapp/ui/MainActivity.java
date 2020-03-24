package com.ismailhakkiaydin.coronavirusapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = activityMainBinding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        countryAdapter = new CountryAdapter(this, countryList, new ItemClickListener() {
            @Override
            public void onItemClick(Country country, int position) {

                Dialog dialog = new Dialog(getApplicationContext());
                dialog.show();



                Toast.makeText(MainActivity.this, "Position " +position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(countryAdapter);


        countryViewModel.getAllCountry().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setCountryList(countries);
            }
        });

    }
}
