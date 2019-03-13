package com.example.android.porownywarkapozyczek.Service;

import com.example.android.porownywarkapozyczek.Model.Loan;

import retrofit.Callback;
import retrofit.http.GET;

public interface MyWebService {
    @GET("/api/api.php/")
    void getData(Callback<Loan> mResponse);

}
