package com.ismailhakkiaydin.coronavirusapp.network.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("country_name")
    private String countryName;
    @SerializedName("cases")
    private String cases;
    @SerializedName("deaths")
    private String deaths;
    @SerializedName("region")
    private String region;
    @SerializedName("total_recovered")
    private String totalRecovered;
    @SerializedName("new_deaths")
    private String newDeaths;
    @SerializedName("new_cases")
    private String newCases;
    @SerializedName("serious_critical")
    private String seriousCritical;
    @SerializedName("active_cases")
    private String activeCases;
    @SerializedName("total_cases_per_1m_population")
    private String totalCasesPer1mPopulation;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getSeriousCritical() {
        return seriousCritical;
    }

    public void setSeriousCritical(String seriousCritical) {
        this.seriousCritical = seriousCritical;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getTotalCasesPer1mPopulation() {
        return totalCasesPer1mPopulation;
    }

    public void setTotalCasesPer1mPopulation(String totalCasesPer1mPopulation) {
        this.totalCasesPer1mPopulation = totalCasesPer1mPopulation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.countryName);
        dest.writeString(this.cases);
        dest.writeString(this.deaths);
        dest.writeString(this.region);
        dest.writeString(this.totalRecovered);
        dest.writeString(this.newDeaths);
        dest.writeString(this.newCases);
        dest.writeString(this.seriousCritical);
        dest.writeString(this.activeCases);
        dest.writeString(this.totalCasesPer1mPopulation);
    }

    public Country() {
    }

    protected Country(Parcel in) {
        this.countryName = in.readString();
        this.cases = in.readString();
        this.deaths = in.readString();
        this.region = in.readString();
        this.totalRecovered = in.readString();
        this.newDeaths = in.readString();
        this.newCases = in.readString();
        this.seriousCritical = in.readString();
        this.activeCases = in.readString();
        this.totalCasesPer1mPopulation = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
