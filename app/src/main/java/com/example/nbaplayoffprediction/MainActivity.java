package com.example.nbaplayoffprediction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText fields for NBA stats
        EditText winLossRecordEditText = findViewById(R.id.editTextWinLossRecord);
        EditText ppgEditText = findViewById(R.id.editTextPPG);
        EditText oppgEditText = findViewById(R.id.editTextOPPG);
        EditText offensiveRatingEditText = findViewById(R.id.editTextOffensiveRating);
        EditText defensiveRatingEditText = findViewById(R.id.editTextDefensiveRating);
        EditText gamesMissedEditText = findViewById(R.id.editTextGamesMissed);
        Button predictButton = findViewById(R.id.buttonRequest);
        TextView predictionResultTextView = findViewById(R.id.predictionText);

        // Button click listener
        predictButton.setOnClickListener(v -> {
            try {
                // Get user inputs from EditText fields and parse them
                double winLossRecord = Double.parseDouble(winLossRecordEditText.getText().toString());
                double ppg = Double.parseDouble(ppgEditText.getText().toString());
                double oppg = Double.parseDouble(oppgEditText.getText().toString());
                double offensiveRating = Double.parseDouble(offensiveRatingEditText.getText().toString());
                double defensiveRating = Double.parseDouble(defensiveRatingEditText.getText().toString());
                double gamesMissed = Double.parseDouble(gamesMissedEditText.getText().toString());

                // Create PredictionRequest with user inputs
                PredictionRequest request = new PredictionRequest(winLossRecord, ppg, oppg, offensiveRating, defensiveRating, gamesMissed);

                // Get Retrofit instance and create PredictionApi
                Retrofit retrofit = RetrofitClient.getRetrofitInstance();
                PredictionApi predictionApi = retrofit.create(PredictionApi.class);

                // Make the API request
                Call<PredictionResponse> call = predictionApi.getPrediction(request);
                call.enqueue(new Callback<PredictionResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<PredictionResponse> call, @NonNull Response<PredictionResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            String prediction = response.body().getPrediction();
                            predictionResultTextView.setText("Prediction: " + prediction);
                        } else {
                            Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PredictionResponse> call, @NonNull Throwable t) {
                        Toast.makeText(MainActivity.this, "Failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
