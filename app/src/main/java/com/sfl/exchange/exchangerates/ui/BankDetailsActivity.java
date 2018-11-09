package com.sfl.exchange.exchangerates.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sfl.exchange.exchangerates.R;

public class BankDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

        init();
    }

    private void init() {
        //find views

        //getExtras from Intent

        //get CompanyStructure object from ViewModel

        setListeners();

        //set RecyclerView adapter
    }

    private void setListeners() {
        // set radio group's callback
    }
}
