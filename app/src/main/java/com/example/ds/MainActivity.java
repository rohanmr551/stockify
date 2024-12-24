package com.example.ds;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.ds.databinding.ActivityMainBinding;  // Import the view binding class

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public interface ApiService {
        @retrofit2.http.GET("predict")
        Call<ApiResponse> getPrediction(@retrofit2.http.Query("stock") String stockSymbol);  // Pass stock as a query parameter
    }

    public static class ApiResponse {
        public String graph1;
        public String graph2;
        public String graph3;
        public String graph4;
        public String graph5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        makeApiCall("AAPL");
    }

    private void makeApiCall(String stockSymbol) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ApiResponse> call = apiService.getPrediction(stockSymbol);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse data = response.body();

                    if (data != null) {
                        Log.d("API Response", "Graph1 URL: " + data.graph1);
                        Log.d("API Response", "Graph2 URL: " + data.graph2);
                        Log.d("API Response", "Graph3 URL: " + data.graph3);
                        Log.d("API Response", "Graph4 URL: " + data.graph4);
                        Log.d("API Response", "Graph4 URL: " + data.graph5);


                        Glide.with(MainActivity.this)
                                .load(data.graph1)
                                .into(binding.graph1ImageView);

                        Glide.with(MainActivity.this)
                                .load(data.graph2)
                                .into(binding.graph2ImageView);

                        Glide.with(MainActivity.this)
                                .load(data.graph3)
                                .into(binding.graph3ImageView);

                        Glide.with(MainActivity.this)
                                .load(data.graph4)
                                .into(binding.graph4ImageView);
                        Glide.with(MainActivity.this)
                                .load(data.graph5)
                                .into(binding.graph5ImageView);
                    }
                } else {
                    Log.e("API Error", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("API Error", "Request failed", t);
            }
        });
    }
}
