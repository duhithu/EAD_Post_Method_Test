package com.example.eadtest2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button1 = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            OkHttpClient client = new OkHttpClient();
                            String BASE_URL = "http://192.168.1.6:8080/api";
                            String json = "{\"customerId\":\"132222222222222222222222\",\"customerName\":\"Jony\",\"email\":\"jony@gmail.com\",\"password\":\"1234\",\"vehicleType\":\"Petrol\",\"arrivalTime\":1,\"departureTime\":0}";
                            RequestBody body = RequestBody.create(
                                    MediaType.parse("application/json"), json);
                            Request request = new Request.Builder()
                                    .url(BASE_URL + "/Station/CreateCustomer")
                                    .post(body)
                                    .build();
                            Call call = client.newCall(request);
                            try {
                                Response response = call.execute();
                                Log.e("Response", response.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }

        });
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try  {
//                            OkHttpClient client = new OkHttpClient();
//                            String BASE_URL = "http://192.168.1.6:8080/api";
//                            Request request = new Request.Builder()
//                                        .url(BASE_URL + "/Station/GetAllCustomerById/{163798232961281790071903}")
//                                        .build();
//                                try
//                                {
//                                    Gson gson = new Gson();
//                                    ResponseBody responseBody = client.newCall(request).execute().body();
//                                    Customer customer = new Customer();
//                                    customer = gson.fromJson(responseBody.string(), Customer.class);
////                                    Response response = client.newCall(request).execute();
////                                    return response.body().string();
////                                    Log.e("Response", customer.getName());
//                                }
//                             catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                thread.start();
//            }
//        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(i);
//                Thread thread = new Thread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        //source - https://stackoverflow.com/questions/9605913/how-do-i-parse-json-in-android
//                        try {
//                            // Create a new HTTP Client
//                            HttpClient defaultClient = new DefaultHttpClient();
//                            // Setup the get request
//                            HttpGet httpGetRequest = new HttpGet("http://192.168.1.6:8080/api/Station/GetAllCustomerById/163798232961281790071903");
//
//                            // Execute the request in the client
//                            HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
//                            // Grab the response
//                            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
//                            String json = reader.readLine();
//
//                            // Instantiate a JSON object from the request response
//                            JSONObject jsonObject = new JSONObject(json);
//
//                            String name = jsonObject.getString("customerName");
//                            Log.e("customerName", name);
//                        } catch (Exception e) {
//                            // In your production code handle any errors and catch the individual exceptions
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                thread.start();
            }
    });
        }

}



