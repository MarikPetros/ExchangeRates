package com.sfl.exchange.exchangerates.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Rate implements Parcelable{
private double buy;
private double sell;

    protected Rate(Parcel in) {
        buy = in.readDouble();
        sell = in.readDouble();
    }

    public static final Creator<Rate> CREATOR = new Creator<Rate>() {
        @Override
        public Rate createFromParcel(Parcel in) {
            return new Rate(in);
        }

        @Override
        public Rate[] newArray(int size) {
            return new Rate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(buy);
        dest.writeDouble(sell);
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }
}
