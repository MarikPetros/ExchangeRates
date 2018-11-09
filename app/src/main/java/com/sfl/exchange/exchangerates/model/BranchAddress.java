package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

class BranchAddress implements Parcelable {
   private String en;

    protected BranchAddress(Parcel in) {
        en = in.readString();
    }

    public static final Creator<BranchAddress> CREATOR = new Creator<BranchAddress>() {
        @Override
        public BranchAddress createFromParcel(Parcel in) {
            return new BranchAddress(in);
        }

        @Override
        public BranchAddress[] newArray(int size) {
            return new BranchAddress[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(en);
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
