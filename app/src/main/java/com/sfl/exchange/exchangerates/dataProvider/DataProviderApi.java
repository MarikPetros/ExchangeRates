package com.sfl.exchange.exchangerates.dataProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProviderApi {
    private static final String BASE_URL = "http://rate.am/ws/mobile/v2/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //getting DataProvider object
    public static DataProvider getDataProvider() {
        return retrofit.create(DataProvider.class);
    }
}
