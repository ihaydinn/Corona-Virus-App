package com.ismailhakkiaydin.coronavirusapp.ui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.databinding.CountryDialogBoxBinding;
import com.ismailhakkiaydin.coronavirusapp.databinding.CountryListItemBinding;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private ItemClickListener mItemClickListener;
    private List<Country> countryList;


    public CountryAdapter(Context context, List<Country> countryList, ItemClickListener mItemClickListener) {
        this.context = context;
        this.countryList = countryList;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        CountryListItemBinding mCountryListItemBinding = CountryListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        final CountryViewHolder countryViewHolder = new CountryViewHolder(mCountryListItemBinding);

        mCountryListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(countryList.get(countryViewHolder.getAdapterPosition()), countryViewHolder.getAdapterPosition());

            }
        });



        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(CountryAdapter.CountryViewHolder holder, int position) {

        Country mCountry = countryList.get(position);
        holder.mCountryListItemBinding.setCountry(mCountry);
        holder.mCountryListItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        if (countryList != null){
            return countryList.size();
        }
        else return 0;
    }

    public void setCountryList(List<Country> countryList){
        this.countryList = countryList;
        notifyDataSetChanged();
    }


    public class CountryViewHolder extends RecyclerView.ViewHolder {


        private CountryListItemBinding mCountryListItemBinding;

        public CountryViewHolder(@NonNull CountryListItemBinding mCountryListItemBinding) {
            super(mCountryListItemBinding.getRoot());

            this.mCountryListItemBinding = mCountryListItemBinding;
        }
    }
}
