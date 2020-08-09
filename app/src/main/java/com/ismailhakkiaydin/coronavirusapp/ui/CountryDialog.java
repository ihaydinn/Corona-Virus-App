package com.ismailhakkiaydin.coronavirusapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.ismailhakkiaydin.coronavirusapp.R;
import com.ismailhakkiaydin.coronavirusapp.databinding.CountryDialogBoxBinding;
import com.ismailhakkiaydin.coronavirusapp.network.dto.Country;

public class CountryDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CountryDialogBoxBinding countryDialogBoxBinding = DataBindingUtil.inflate(inflater, R.layout.country_dialog_box, container, false);
        View view = countryDialogBoxBinding.getRoot();

        Country country = getArguments().getParcelable("country_detail");
        countryDialogBoxBinding.setDialog(country);

        return view;
    }
}
