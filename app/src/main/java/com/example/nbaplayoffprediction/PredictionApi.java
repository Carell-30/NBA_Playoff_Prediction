package com.example.nbaplayoffprediction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PredictionApi {
    @POST("/predict")  // Ensure this path matches your server
    Call<PredictionResponse> getPrediction(@Body PredictionRequest request);
}