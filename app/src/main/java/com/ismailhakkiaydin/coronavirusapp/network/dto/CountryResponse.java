package com.ismailhakkiaydin.coronavirusapp.network.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryResponse {

    @SerializedName("countries_stat")
    private List<Country> countriesStat = null;

    public List<Country> getCountriesStat() {
        return countriesStat;
    }

    public void setCountriesStat(List<Country> countriesStat) {
        this.countriesStat = countriesStat;
    }

}