package com.example.android.porownywarkapozyczek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.porownywarkapozyczek.Model.Loan;
import com.example.android.porownywarkapozyczek.Service.MyWebService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RestAdapter retrofit;
    private MyWebService myWebService;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        retrofit = new RestAdapter.Builder()
                .setEndpoint("http://www.filmyseriale.online/")
                .build();
        myWebService = retrofit.create(MyWebService.class);

        myWebService.getData(new Callback<Loan>() {
            @Override
            public void success(Loan loan, Response response) {
                tv.setText(loan.getNazwa());
            }

            @Override
            public void failure(RetrofitError error) {
                error.getLocalizedMessage();
                System.out.println("ERROR");
            }
        });
    }
}
