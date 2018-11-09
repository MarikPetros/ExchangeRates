package com.sfl.exchange.exchangerates.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Branch implements Parcelable {
   private BranchTitle title;
   private BranchAddress address;
   private BranchLocation location;
   private String contacts;
   private List<Workhours> workhours;


    protected Branch(Parcel in) {
        title = in.readParcelable(BranchTitle.class.getClassLoader());
        address = in.readParcelable(BranchAddress.class.getClassLoader());
        location = in.readParcelable(BranchLocation.class.getClassLoader());
        contacts = in.readString();
        workhours = in.createTypedArrayList(Workhours.CREATOR);
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
        dest.writeParcelable(address, flags);
        dest.writeParcelable(location, flags);
        dest.writeString(contacts);
        dest.writeTypedList(workhours);
    }

    public BranchTitle getTitle() {
        return title;
    }

    public void setTitle(BranchTitle title) {
        this.title = title;
    }

    public BranchAddress getAddress() {
        return address;
    }

    public void setAddress(BranchAddress address) {
        this.address = address;
    }

    public BranchLocation getLocation() {
        return location;
    }

    public void setLocation(BranchLocation location) {
        this.location = location;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public List<Workhours> getWorkhours() {
        return workhours;
    }

    public void setWorkhours(List<Workhours> workhours) {
        this.workhours = workhours;
    }
}
