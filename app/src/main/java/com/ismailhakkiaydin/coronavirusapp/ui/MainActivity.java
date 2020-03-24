package com.ismailhakkiaydin.coronavirusapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiClient;
import com.ismailhakkiaydin.coronavirusapp.network.client.ApiService;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;
import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.CountryAdapter;
import com.ismailhakkiaydin.coronavirusapp.ui.adapter.ItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private List<Country> countryList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ApiService apiService;

        apiService = ApiClient.getClient().create(ApiService.class);
        Call<CountryResponse> call = apiService.getCountry();
        call.enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                countryList = response.body().getCountriesStat();
                Log.e("ERROR : ", "" + countryList.size());
                countryAdapter = new CountryAdapter(getApplicationContext(), countryList, new ItemClickListener() {
                    @Override
                    public void onItemClick(Country country, int position) {
                        Toast.makeText(MainActivity.this, "Toplam " +countryList.size(), Toast.LENGTH_SHORT).show();
                    }
                });
                recyclerView.setAdapter(countryAdapter);

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });
    }
}
