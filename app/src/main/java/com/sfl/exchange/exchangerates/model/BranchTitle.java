package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BranchTitle implements Parcelable {
    String en;

    protected BranchTitle(Parcel in) {
        en = in.readString();
    }

    public static final Creator<BranchTitle> CREATOR = new Creator<BranchTitle>() {
        @Override
        public BranchTitle createFromParcel(Parcel in) {
            return new BranchTitle(in);
        }

        @Override
        public BranchTitle[] newArray(int size) {
            return new BranchTitle[size];
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
