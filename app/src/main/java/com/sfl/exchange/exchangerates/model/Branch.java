package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Branch implements Parcelable {
    BranchTitle title;
    BranchLocation location;

    protected Branch(Parcel in) {
        title = in.readParcelable(BranchTitle.class.getClassLoader());
        location = in.readParcelable(BranchLocation.class.getClassLoader());
    }

    public static final Creator<Branch> CREATOR = new Creator<Branch>() {
        @Override
        public Branch createFromParcel(Parcel in) {
            return new Branch(in);
        }

        @Override
        public Branch[] newArray(int size) {
            return new Branch[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(title, flags);
        dest.writeParcelable(location, flags);
    }

    public BranchTitle getTitle() {
        return title;
    }

    public void setTitle(BranchTitle title) {
        this.title = title;
    }

    public BranchLocation getLocation() {
        return location;
    }

    public void setLocation(BranchLocation location) {
        this.location = location;
    }
}
