package com.example.android.porownywarkapozyczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.porownywarkapozyczek.Controller.LoanApi;
import com.example.android.porownywarkapozyczek.Model.Loan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private LoanApi loanApi;
    private ListView lvListOfLOan;
    private ArrayList<Loan> listOfLoan;
    private ArrayAdapter<Loan> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanApi = new LoanApi();
        lvListOfLOan = (ListView)findViewById(R.id.lvListOfLoan);

        for(int i=0; i<loanApi.getListOfLoan().size(); i++) {
            System.out.println(loanApi.getListOfLoan().get(i).getNazwa());
        }

        listOfLoan = (ArrayList<Loan>) loanApi.getListOfLoan();

        adapter = new ArrayAdapter<Loan>(this, R.layout.row_of_loan, listOfLoan);
    }
}
