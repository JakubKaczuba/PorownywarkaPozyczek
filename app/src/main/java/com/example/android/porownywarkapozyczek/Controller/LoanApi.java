package com.example.android.porownywarkapozyczek.Controller;

import android.widget.TextView;

import com.example.android.porownywarkapozyczek.Model.Loan;
import com.example.android.porownywarkapozyczek.Service.MyWebService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoanApi implements Callback<List<Loan>> {
    private static final String BASE_URL = "http://www.filmyseriale.online/";
    private Gson gson;
    private Retrofit retrofit;
    private List<Loan> listOfLoan;

    public LoanApi() {
        listOfLoan = new ArrayList<Loan>();
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MyWebService api = retrofit.create(MyWebService.class);
        Call<List<Loan>> call = api.getData();
        call.enqueue(this);
    }

    public List<Loan> getListOfLoan() {
        return listOfLoan;
    }

    @Override
    public void onResponse(Call<List<Loan>> call, Response<List<Loan>> response) {
        listOfLoan = response.body();
    }

    @Override
    public void onFailure(Call<List<Loan>> call, Throwable t) {
        System.out.println("ERROR");
    }
}
