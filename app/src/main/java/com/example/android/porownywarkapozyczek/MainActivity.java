package com.example.android.porownywarkapozyczek;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

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
    private Spinner spLoanChooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListOfLOan = (ListView) findViewById(R.id.lvListOfLoan);
        listOfLoan = new ArrayList<Loan>();
        spLoanChooser = (Spinner) findViewById(R.id.spLoanChooser);
        List<String> list = new ArrayList<String>();
        list.add("Pożyczka krótkoterminowa");
        list.add("Pożyczka długoterminowa");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        spLoanChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lvListOfLOan.setAdapter(new LoansAdapter(getApplicationContext(), listOfLoan,  position));
                LoansAdapter adapter = (LoansAdapter) lvListOfLOan.getAdapter();
                //adapter.getFilter().filter(String.valueOf(sbDistance.getProgress()));
                adapter.getFilter().filter(String.valueOf(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
            new DownloadImageTask1(i).execute("https://cdn.shoplo.com/1785/products/th1024/aaaf/137-piesek.jpg");
        }

        loansAdapter = new LoansAdapter(this, listOfLoan, 0);
        lvListOfLOan.setAdapter(loansAdapter);
        lvListOfLOan.invalidate();

    }

    @Override
    public void onFailure(Call<List<Loan>> call, Throwable t) {
        System.out.println("ERROR");
        System.out.println(t.getMessage());
    }

    class DownloadImageTask1 extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
         int licznik;

        public DownloadImageTask1(int licznik) {
            this.licznik = licznik;

        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            System.out.println(urldisplay);
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }



        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @SuppressWarnings("unused")
        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            listOfLoan.get(licznik).setLogoBitmp(result);

            System.out.println(listOfLoan.size());

            //MainActivity main = new MainActivity();
        if(licznik == listOfLoan.size()-1){
            loansAdapter = new LoansAdapter(MainActivity.this, listOfLoan, 0);
            lvListOfLOan.setAdapter(loansAdapter);
            lvListOfLOan.invalidate();
        }

        }
    }

}

