package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BranchLocation implements Parcelable {
    private float lat;
    private float lng;

    protected BranchLocation(Parcel in) {
        lat = in.readFloat();
        lng = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(lat);
        dest.writeFloat(lng);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BranchLocation> CREATOR = new Creator<BranchLocation>() {
        @Override
        public BranchLocation createFromParcel(Parcel in) {
            return new BranchLocation(in);
        }

        @Override
        public BranchLocation[] newArray(int size) {
            return new BranchLocation[size];
        }
    };

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
