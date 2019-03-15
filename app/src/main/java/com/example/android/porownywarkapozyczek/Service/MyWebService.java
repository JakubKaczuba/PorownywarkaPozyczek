package com.example.android.porownywarkapozyczek.Service;

import com.example.android.porownywarkapozyczek.Model.Loan;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyWebService {
    @GET("/api/api.php")
    Call<List<Loan>> getData();
}
