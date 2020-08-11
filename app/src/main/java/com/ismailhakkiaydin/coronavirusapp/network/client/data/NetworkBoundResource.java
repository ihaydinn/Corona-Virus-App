package com.ismailhakkiaydin.coronavirusapp.network.client.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ismailhakkiaydin.coronavirusapp.network.dto.CountryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkBoundResource<ResultType> {

    private final MutableLiveData<ResultType> resultData = new MutableLiveData<>();
    private Context mContex;

    public Context getContex() {
        return mContex;
    }

    @MainThread
    public NetworkBoundResource() {
//        resultData.setValue();

        handleInternetConnection();

    }

    private void handleInternetConnection() {
      /*  if (CheckInternet.isInternetAvailable(getContex())) {
            fetchFromNetwork();
        } else {
            Log.e("ERROR", "İnternet bağlantınızı kontrol ediniz...");
        }*/

      fetchFromNetwork();

    }

    private void fetchFromNetwork() {
        createCall().enqueue(new Callback<ResultType>() {
            @Override
            public void onResponse(Call<ResultType> call, Response<ResultType> response) {

                if (response.raw().code() == 401)
                    Log.e("ERROR", "Error 401");

                if (response.body() != null) {
                    if (response.body() instanceof CountryResponse) {
                        Log.i("INFO", "Kayıt Bulundu...");
                        handleSuccess(response);
                    } else {
                        Log.e("ERROR", "Kayıt Bulunamadı...");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultType> call, Throwable t) {
                onFetchFailed();
                Log.e("ERROR", "" + t.getLocalizedMessage() + " " + t.getMessage());
            }
        });
    }

    private void handleSuccess(Response<ResultType> response) {
        resultData.setValue(response.body());
    }


    @NonNull
    @MainThread
    protected abstract Call<ResultType> createCall();

    @MainThread
    protected void onFetchFailed() {
    }

    public LiveData<ResultType> getResultData() {
        return resultData;
    }
}
