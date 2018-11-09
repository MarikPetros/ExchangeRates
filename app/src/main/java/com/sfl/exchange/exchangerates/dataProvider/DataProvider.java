package com.sfl.exchange.exchangerates.dataProvider;

import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.model.CompanyStructure;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataProvider {
    @GET("rates.ashx?lang=en")
    Call<List<Company>> getBanksList();

    @GET("branches.ashx")
    Call<CompanyStructure> getBankStructure(@Query("id") String id);
}
