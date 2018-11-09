package com.sfl.exchange.exchangerates.ui;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.model.CompanyStructure;
import com.sfl.exchange.exchangerates.repository.Repository;

import java.util.List;

public class RatesViewModel extends ViewModel {
    private Repository repository;

    public RatesViewModel() {
        repository = Repository.getInstance();
    }

    public List<Company> getBanks(Context context){
        return repository.getCompanies(context);
    }

    public CompanyStructure getBankStructure(Context context, String id){
        return repository.getCompanyStructuee(context, id);
    }
}
