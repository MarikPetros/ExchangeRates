package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class CompanyStructure implements Parcelable {
    private List<Branch> list;

    protected CompanyStructure(Parcel in) {
        list = in.createTypedArrayList(Branch.CREATOR);
    }

    public static final Creator<CompanyStructure> CREATOR = new Creator<CompanyStructure>() {
        @Override
        public CompanyStructure createFromParcel(Parcel in) {
            return new CompanyStructure(in);
        }

        @Override
        public CompanyStructure[] newArray(int size) {
            return new CompanyStructure[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(list);
    }

    public List<Branch> getList() {
        return list;
    }

    public void setList(List<Branch> list) {
        this.list = list;
    }
}
