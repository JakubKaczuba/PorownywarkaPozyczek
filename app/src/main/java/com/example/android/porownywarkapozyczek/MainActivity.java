package com.example.android.porownywarkapozyczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.porownywarkapozyczek.Controller.LoanApi;

public class MainActivity extends AppCompatActivity  {

    private LoanApi loanApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanApi = new LoanApi();

        for(int i=0; i<loanApi.getListOfLoan().size(); i++) {
            System.out.println(loanApi.getListOfLoan().get(i).getNazwa());
        }

    }
}
