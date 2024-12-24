package com.example.ds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StockPredictionApi {
    @GET("/predict/{stock_symbol}")
    Call<StockDataModel> getStockPrediction(@Path("stock_symbol") String stockSymbol);
}
