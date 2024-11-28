package com.example.nbaplayoffprediction;

import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://192.168.1.89:5000";  // Ensure this is your server's IP or localhost
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(
                            new GsonBuilder().setLenient().create()
                    ))
                    .build();
        }
        return retrofit;
    }
}
