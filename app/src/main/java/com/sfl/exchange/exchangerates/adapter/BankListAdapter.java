package com.sfl.exchange.exchangerates.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfl.exchange.exchangerates.R;
import com.sfl.exchange.exchangerates.adapter.view_holderl.BankListItemViewHolder;
import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.utils.Currencies;
import com.sfl.exchange.exchangerates.utils.PayMode;

import java.util.List;

public class BankListAdapter extends RecyclerView.Adapter<BankListItemViewHolder> {
    private OnItemSelectedListener mListener;
    private List<Company> mCompanyList;
    private Currencies mCurrency;
    private PayMode mMode;
    private BankListItemViewHolder mViewHolder;

    public void setOnItemSelectedListener(OnItemSelectedListener mListener) {
        this.mListener = mListener;
    }

    BankListItemViewHolder.OnItemClickListener onItemClickListener = new BankListItemViewHolder.OnItemClickListener() {
        @Override
        public void onItemClick(int adapterPosition) {
            mListener.onItemSelected(getItemByPosition(adapterPosition));
        }
    };

    public BankListAdapter(List<Company> companies, Currencies currency, PayMode mode) {
        mCompanyList = companies;
        mCurrency = currency;
        mMode = mode;
    }


    @NonNull
    @Override
    public BankListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_list_item, viewGroup, false);
        mViewHolder = new BankListItemViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BankListItemViewHolder bankListItemViewHolder, int i) {
        Company company = mCompanyList.get(i);
        bankListItemViewHolder.bind(company, mCurrency, mMode);
    }

    @Override
    public int getItemCount() {
        return mCompanyList.size();
    }

    private Company getItemByPosition(int position){
        return mCompanyList.get(position);
    }

    public interface  OnItemSelectedListener{
       void onItemSelected(Company listItem);
    }
}
