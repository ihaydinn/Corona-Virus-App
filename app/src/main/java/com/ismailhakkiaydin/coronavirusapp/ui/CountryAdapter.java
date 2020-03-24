package com.ismailhakkiaydin.coronavirusapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private Context context;

    private List<Country> countryList;


    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_list_item, parent, false);

        final MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CountryAdapter.MyViewHolder holder, int position) {

        holder.tvCountryName.setText(countryList.get(position).getCountryName());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tvCountryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvCountryName = itemView.findViewById(R.id.textView);
        }
    }
}
