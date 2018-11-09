package com.sfl.exchange.exchangerates.adapter.view_holderl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sfl.exchange.exchangerates.R;
import com.sfl.exchange.exchangerates.model.Company;
import com.sfl.exchange.exchangerates.model.Currency;
import com.sfl.exchange.exchangerates.utils.Currencies;
import com.sfl.exchange.exchangerates.utils.PayMode;

import java.util.List;
import java.util.Locale;

public class BankListItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView logo;
    private TextView tvName;
    private TextView tvDistance;
    private TextView tvBuyValue;
    private TextView tvSellValue;
    private String mBuyVal;
    private String mSellVal;

    private OnItemClickListener mOnItemClickListener;

    private View.OnClickListener mOnClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null){}
            mOnItemClickListener.onItemClick(getAdapterPosition());
        }
    };

    public BankListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.logo_image);
        tvName = itemView.findViewById(R.id.nameText);
        tvDistance = itemView.findViewById(R.id.distanceText);
        tvBuyValue = itemView.findViewById(R.id.buyValueText);
        tvSellValue = itemView.findViewById(R.id.sellValueText);

        itemView.setOnClickListener(mOnClicklistener);
    }

    public void bind(Company company, Currencies currency, PayMode mode) {
        //get bay and sell values
        getBuyValue(company, currency, mode);

        tvName.setText(company.getTitle());
        tvDistance.setText(String.format(Locale.getDefault(), " %d km", 1));//TODO set distance
        tvBuyValue.setText(mBuyVal);
        tvName.setText(mSellVal);
    }

    private void getBuyValue(Company company, Currencies currency, PayMode mode) {
        List<Currency> currencyList = company.getList();

        for (Currency curr : currencyList) {
            if (curr.getName() == currency.toString()) {
                if (mode == PayMode.CASH) {
                    switch (currency) {
                        case USD:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case EUR:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case RUR:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case AUD:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case CAD:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case CHF:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case GBP:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case GEL:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case JPY:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        case XAU:
                            mBuyVal = Double.toString(curr.getRates()[0].getBuy());
                            mSellVal = Double.toString(curr.getRates()[0].getSell());
                        default:
                            mBuyVal = "";
                            mSellVal = "";
                    }
                } else if (mode == PayMode.NOCASH) {
                    switch (currency) {
                        case USD:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case EUR:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case RUR:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case AUD:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case CAD:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case CHF:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case GBP:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case GEL:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case JPY:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        case XAU:
                            mBuyVal = Double.toString(curr.getRates()[1].getBuy());
                            mSellVal = Double.toString(curr.getRates()[1].getSell());
                        default:
                            mBuyVal = "";
                            mSellVal = "";
                    }
                }
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int adapterPosition);
    }
}