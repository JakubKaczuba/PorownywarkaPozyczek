package com.example.android.porownywarkapozyczek;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.porownywarkapozyczek.Controller.LoanApi;
import com.example.android.porownywarkapozyczek.Model.Loan;
import com.example.android.porownywarkapozyczek.Model.LoansAdapter;
import com.example.android.porownywarkapozyczek.Service.MyWebService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<Loan>> {

    private LoanApi loanApi;
    private ListView lvListOfLOan;
    private ArrayAdapter<Loan> adapter;
    private static final String BASE_URL = "http://www.filmyseriale.online/";
    private Gson gson;
    private Retrofit retrofit;
    private List<Loan> listOfLoan;
    private MyWebService api;
    private LoansAdapter loansAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListOfLOan = (ListView) findViewById(R.id.lvListOfLoan);
        listOfLoan = new ArrayList<Loan>();
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(MyWebService.class);

        Call<List<Loan>> call = api.getData();
        call.enqueue(this);








        /*

        loanApi = new LoanApi();
        lvListOfLOan = (ListView)findViewById(R.id.lvListOfLoan);
        loanApi.test();
        for(int i=0; i<loanApi.getListOfLoan().size(); i++) {
            System.out.println(loanApi.getListOfLoan().get(i).getNazwa());
        }


        listOfLoan = (ArrayList<Loan>) loanApi.getListOfLoan();

        adapter = new ArrayAdapter<Loan>(this, R.layout.row_of_loan, listOfLoan);

        */
    }

    @Override
    public void onResponse(Call<List<Loan>> call, Response<List<Loan>> response) {
        System.out.println(response.body());
        listOfLoan = response.body();
        for(int i=0; i<listOfLoan.size(); i++) {
            System.out.println(listOfLoan.get(i).getNazwa());
        }

        loansAdapter = new LoansAdapter(this, listOfLoan, 0);
        lvListOfLOan.setAdapter(loansAdapter);
        lvListOfLOan.invalidate();

    }

    @Override
    public void onFailure(Call<List<Loan>> call, Throwable t) {
        System.out.println("ERROR");
    }


}

