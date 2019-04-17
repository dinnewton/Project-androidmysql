package com.kennedy.mysqlapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.SyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class FetchActivity extends AppCompatActivity {
    @BindView(R.id.borroewrs_List)
    ListView list;

    SimpleAdapter adapter;

    ArrayList<Item> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        ButterKnife.bind(this);

        adapter = new SimpleAdapter(this, array);

        list.setAdapter(adapter);
        fetch();
    }

    public void fetch(){
        String url="http://e0616233.ngrok.io/andy/fetch.php";

        AsyncHttpClient client = new SyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(FetchActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Toast.makeText(FetchActivity.this, "Success", Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jarray = new JSONArray(responseString);

                    for (int i = 0; i <jarray.length() ; i++) {
                        JSONObject x = jarray.getJSONObject(i);
                        int id = x.getInt("id");
                        String name = x.getString("name");
                                int amount = x.getInt(("amount"));

                                Item t =new Item(id,name,amount);

                                array.add(t);


                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
