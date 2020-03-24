package com.ismailhakkiaydin.coronavirusapp.ui.adapter;

import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;

public interface ItemClickListener {
    void onItemClick(Country country, int position);
}
