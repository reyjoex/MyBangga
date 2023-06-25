package com.mobile.mybangga;

import android.icu.text.NumberFormat;

import java.util.Locale;

public class Fungsi {

    public String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        formatRupiah.setMaximumFractionDigits(0);
        return formatRupiah.format(number);
    }

    public String formatNonRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getNumberInstance(localeID);
        formatRupiah.setMaximumFractionDigits(0);
        return formatRupiah.format(number);
    }

}
