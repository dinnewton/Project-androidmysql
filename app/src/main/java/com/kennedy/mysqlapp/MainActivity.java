package com.kennedy.mysqlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;
import ir.alirezabdn.wp7progress.WP7ProgressBar;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.inputBorrower)
       EditText inputBorrower;
    @BindView(R.id.inputAmount)
       EditText inputAmount;
    @BindView(R.id.progressBar)
    WP7ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.buttonSave)
    public  void  save()
    {
        //saving

     String name =inputBorrower.getText().toString().trim();
     String amount =inputAmount.getText().toString().trim();

     if(name.isEmpty()|| amount.isEmpty()){
         Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
         return;
     }
     String url="http://b3d4911e.ngrok.io/andy/save.php";
        RequestParams params=new RequestParams();
        params.put("name",name);
        params.put("amount",amount);

        AsyncHttpClient client=new AsyncHttpClient();

        progressBar.showProgressBar();
        client.post( url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                progressBar.hideProgressBar();
                Toast.makeText(MainActivity.this, "Failed to save Try Again", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                progressBar.hideProgressBar();
                Toast.makeText(MainActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();

            }
        });




    }

    @OnClick(R.id.buttonView)
    public void  view() {
        //navigate to next page
        Intent x = new Intent(this, FetchActivity.class);
        startActivity(x);


    }

        }


