package com.sfl.exchange.exchangerates.utils;

import android.content.Context;
import android.location.Location;

import com.sfl.exchange.exchangerates.model.Branch;
import com.sfl.exchange.exchangerates.model.BranchLocation;
import com.sfl.exchange.exchangerates.model.CompanyStructure;
import com.sfl.exchange.exchangerates.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class MinDistance {
    private Context mContext;
    private CurrentLocation mCurrentLocation;

    public MinDistance(Context context) {
        this.mContext = context;
    }

    public float getMinDidtance(String id) {
        return calculateLocation(getBranchLocations(id));
    }

    private List<BranchLocation> getBranchLocations(String id) {
        //getting company structure by id
        Repository repository = Repository.getInstance();
        CompanyStructure companyStructure = repository.getCompanyStructuee(mContext, id);

        List<BranchLocation> locations = new ArrayList<>();

        for (Branch branch : companyStructure.getList()) {
            locations.add(branch.getLocation());
        }

        return locations;
    }

    private float calculateLocation(List<BranchLocation> locationList) {
        float[] distance = new float[1];
        List<Float> distances = new ArrayList<>();
        float minDistance = 0f;

        for (int i = 0; i < locationList.size(); i++) {
            Location.distanceBetween(mCurrentLocation.getCurrentLocation().getLatitude(), mCurrentLocation.getCurrentLocation().getLongitude(),
                    locationList.get(i).getLat(), locationList.get(i).getLng(), distance);
            distances.add(distance[0]);
        }

        for (int i = 1; i < distances.size() ; i++) {
            float tempresult = distances.get(i);

            if(tempresult < distances.get(i-1)) minDistance = tempresult;
        }
        return minDistance;
    }
}

