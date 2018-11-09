package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Currency implements Parcelable{
    private String name;
    private Rate[] rates;


    protected Currency(Parcel in) {
        name = in.readString();
        rates = in.createTypedArray(Rate.CREATOR);
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedArray(rates, flags);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rate[] getRates() {
        return rates;
    }

    public void setRates(Rate[] rates) {
        this.rates = rates;
    }
}
