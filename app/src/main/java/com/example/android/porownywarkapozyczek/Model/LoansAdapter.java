package com.example.android.porownywarkapozyczek.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.porownywarkapozyczek.R;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LoansAdapter extends BaseAdapter {

    private Context context;
    private List<Loan> listOfLoan;
    private List<Loan> filteredList;
    private TextView tvLoanValueRange;
    private TextView tvLoanDays;
    private TextView tvIsFirstLoanFree;
    private Button buttonSubmit;
    private ImageView ivLogo;
    private int selectedCampaignId;
    private ViewHolder holder;


    public LoansAdapter(Context context, List<Loan> listOfLoan, int selectedCampaignId) {
        this.context = context;
        this.listOfLoan = listOfLoan;
        this.filteredList = listOfLoan;
        this.selectedCampaignId = selectedCampaignId;
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int i) {
        return filteredList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_of_loan, parent, false);
            holder = new ViewHolder();

            holder.tvLoanValueRange = (TextView) convertView.findViewById(R.id.tvLoanValueRange);
            holder.tvLoanDays = (TextView) convertView.findViewById(R.id.tvLoanDays);
            holder.tvIsFirstLoanFree = (TextView) convertView.findViewById(R.id.tvIsFirstLoanFree);
            holder.ivLogo = (ImageView) convertView.findViewById(R.id.ivLoanLogoView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        int corePoolSize = 60;
        int maximumPoolSize = 80;
        int keepAliveTime = 10;

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(maximumPoolSize);
        Executor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
        new DownloadImageTask1(ivLogo).execute("https://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/10944-home_default/obrazek-obrazki-de-10-11.jpg");

        new DownloadImageTask1(ivLogo).executeOnExecutor(threadPoolExecutor, "https://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/10944-home_default/obrazek-obrazki-de-10-11.jpg");
        holder.tvLoanValueRange.setText("od " + filteredList.get(position).getKwota_min() + " do " +
                filteredList.get(position).getKwota_max());
        holder.tvLoanDays.setText("od " + filteredList.get(position).getDZIEN_MIN() + " do " +
                filteredList.get(position).getDZIEN_MAX());

        System.out.println("GET VIEW DZIALA");
        if (selectedCampaignId == 0){
            if(filteredList.get(position).getcampaignCategoryId() == 0){
               if(filteredList.get(position).getisFirstLoanFree()) {
                   holder.tvIsFirstLoanFree.setText("Pierwsza darmowa: TAK");
               }
               else
               {
                   holder.tvIsFirstLoanFree.setText("Pierwsza darmowa: NIE");
               }
            }

        }
    return convertView;
    }


    static class ViewHolder{
        TextView tvLoanValueRange;
        TextView tvLoanDays;
        TextView tvIsFirstLoanFree;
        Button buttonSubmit;
        ImageView ivLogo;
    }
}
class DownloadImageTask1 extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    static Integer licznik = 1;

    public DownloadImageTask1(ImageView bmImage) {
        this.bmImage = bmImage;
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


        System.out.println("DUUUUPA");
        //MainActivity main = new MainActivity();


    }
}