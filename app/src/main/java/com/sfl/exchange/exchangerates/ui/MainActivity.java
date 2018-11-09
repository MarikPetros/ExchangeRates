package com.sfl.exchange.exchangerates.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfl.exchange.exchangerates.R;
import com.sfl.exchange.exchangerates.adapter.BankListAdapter;
import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.model.CompanyStructure;
import com.sfl.exchange.exchangerates.utils.Currencies;
import com.sfl.exchange.exchangerates.utils.PayMode;

import java.util.List;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    public static final String BANK_ID = "id_of_bank";
    private static final String[] TYPE_SPINNER = {PayMode.CASH.toString(), PayMode.NOCASH.toString()};
    private static final String[] CURRENCY_SPINNER = {Currencies.USD.toString(), Currencies.EUR.toString(), Currencies.RUR.toString(),
            Currencies.AUD.toString(), Currencies.CAD.toString(), Currencies.CHF.toString(), Currencies.GBP.toString(),
            Currencies.GEL.toString(), Currencies.JPY.toString(), Currencies.XAU.toString()};

    private Spinner mTypeSpinner, mCurrencySpinner;
    private ImageView mImgLocations;
    private TextView mDistance, mBuy, mSell;

    private RatesViewModel mViewModel;
    private List<Company> mCompanies;
    private Currencies mCurrency;
    private PayMode mMode;
    private CompanyStructure mCompanyStructure;

    private BankListAdapter mAdapter;
    BankListAdapter.OnItemSelectedListener mAdapterListener = new BankListAdapter.OnItemSelectedListener() {
        @Override
        public void onItemSelected(Company listItem) {
            Intent intent = new Intent(MainActivity.this,BankDetailsActivity.class);
            intent.putExtra(BANK_ID,listItem.getId());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private  void init(){
        //finding views
        mTypeSpinner = findViewById(R.id.spinner_type);
        mCurrencySpinner = findViewById(R.id.spinner_currency);
        mImgLocations = findViewById(R.id.image_locations);
        mDistance = findViewById(R.id.text_distance);
        mBuy = findViewById(R.id.text_buy);
        mSell = findViewById(R.id.text_sell);
        RecyclerView mRecyclerView = findViewById(R.id.main_list_recycler_view);

        //setting spinner adapters
        ArrayAdapter<String> typeSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, TYPE_SPINNER);
        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTypeSpinner.setAdapter(typeSpinnerAdapter);

        ArrayAdapter<String> currencySpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CURRENCY_SPINNER);
        currencySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCurrencySpinner.setAdapter(currencySpinnerAdapter);

        setListeners();

        //setting recycler view adapter
        getRemoteData();
        mAdapter = new BankListAdapter(mCompanies, mCurrency, mMode);
        mAdapter.setOnItemSelectedListener(mAdapterListener);
        mRecyclerView.setAdapter(mAdapter);

    }

    private  void getRemoteData(){
        mViewModel = ViewModelProviders.of(MainActivity.this).get(RatesViewModel.class);
        mCompanies =  mViewModel.getBanks(MainActivity.this);
    }

    private  void  setListeners(){
        mTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                if (item.equals(PayMode.CASH.toString())) mMode = PayMode.CASH;
                else mMode = PayMode.NOCASH;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mMode = PayMode.CASH;
            }
        });

        mCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                if (item.equals(Currencies.USD.toString())) mCurrency = Currencies.USD;
                else if (item.equals(Currencies.EUR.toString())) mCurrency = Currencies.EUR;
                else if (item.equals(Currencies.RUR.toString())) mCurrency = Currencies.RUR;
                else if (item.equals(Currencies.AUD.toString())) mCurrency = Currencies.AUD;
                else if (item.equals(Currencies.CAD.toString())) mCurrency = Currencies.CAD;
                else if (item.equals(Currencies.CHF.toString())) mCurrency = Currencies.CHF;
                else if (item.equals(Currencies.GBP.toString())) mCurrency = Currencies.GBP;
                else if (item.equals(Currencies.GEL.toString())) mCurrency = Currencies.GEL;
                else if (item.equals(Currencies.JPY.toString())) mCurrency = Currencies.JPY;
                else if (item.equals(Currencies.XAU.toString())) mCurrency = Currencies.XAU;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCurrency = Currencies.USD;
            }
        });
    }
}
