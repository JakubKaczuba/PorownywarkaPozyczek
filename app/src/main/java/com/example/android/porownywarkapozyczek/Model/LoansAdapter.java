package com.example.android.porownywarkapozyczek.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LoansAdapter extends BaseAdapter {

    private Context context;
    private List<Loan> listOfLoan;
    private TextView tvLoanValueRange;
    private TextView loanDays;
    private TextView tvIsFirstLoanFree;


    public LoansAdapter(Context context, List<Loan> listOfLoan) {
        this.context = context;
        this.listOfLoan = listOfLoan;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return listOfLoan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
