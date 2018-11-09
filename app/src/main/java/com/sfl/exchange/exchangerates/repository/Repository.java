package com.sfl.exchange.exchangerates.repository;

import android.content.Context;
import android.widget.Toast;

import com.sfl.exchange.exchangerates.dataProvider.DataProviderApi;
import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.model.CompanyStructure;
import com.sfl.exchange.exchangerates.utils.ConnectivityUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static Repository sRepository;
    //private Context mContext;
    private List<Company> mCompanies = new ArrayList<>();
    private CompanyStructure mCompanyStructure;

    private Repository() {
    }

    public  static Repository getInstance() {
        if (sRepository == null) {
            sRepository = new Repository();
        }
        return sRepository;
    }

    public List<Company> getCompanies(Context context) {
        if (ConnectivityUtil.isNetworkAvailable(context)) {
            Call<List<Company>> listCall = DataProviderApi.getDataProvider().getBanksList();
            listCall.enqueue(new Callback<List<Company>>() {
                @Override
                public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                    mCompanies = response.body();
                }

                @Override
                public void onFailure(Call<List<Company>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }else {
            Toast.makeText(context,"Internet is not available!",Toast.LENGTH_LONG).show();
        }
        return mCompanies;
    }

    public CompanyStructure getCompanyStructuee(Context context , String id) {
        if (ConnectivityUtil.isNetworkAvailable(context)) {
            Call<CompanyStructure> structureCall = DataProviderApi.getDataProvider().getBankStructure(id);
            structureCall.enqueue(new Callback<CompanyStructure>() {
                @Override
                public void onResponse(Call<CompanyStructure> call, Response<CompanyStructure> response) {
                    mCompanyStructure = response.body();
                }

                @Override
                public void onFailure(Call<CompanyStructure> call, Throwable t) {

                }
            });
        }else {
            Toast.makeText(context,"Internet is not available!",Toast.LENGTH_LONG).show();
        }
        return mCompanyStructure;
    }
}
