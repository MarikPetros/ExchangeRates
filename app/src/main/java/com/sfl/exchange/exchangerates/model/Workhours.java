package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

class Workhours implements Parcelable {
   private String days;
   private String hours;

    protected Workhours(Parcel in) {
        days = in.readString();
        hours = in.readString();
    }

    public static final Creator<Workhours> CREATOR = new Creator<Workhours>() {
        @Override
        public Workhours createFromParcel(Parcel in) {
            return new Workhours(in);
        }

        @Override
        public Workhours[] newArray(int size) {
            return new Workhours[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(days);
        dest.writeString(hours);
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
