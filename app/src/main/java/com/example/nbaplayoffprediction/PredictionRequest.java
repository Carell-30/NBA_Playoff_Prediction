package com.example.nbaplayoffprediction;

import com.google.gson.annotations.SerializedName;

public class PredictionRequest {

    @SerializedName("win_loss_record")
    private double winLossRecord;

    @SerializedName("ppg")
    private double ppg;

    @SerializedName("oppg")
    private double oppg;

    @SerializedName("offensive_rating")
    private double offensiveRating;

    @SerializedName("defensive_rating")
    private double defensiveRating;

    @SerializedName("games_missed")
    private double gamesMissed;

    // Constructor
    public PredictionRequest(double winLossRecord, double ppg, double oppg, double offensiveRating, double defensiveRating, double gamesMissed) {
        this.winLossRecord = winLossRecord;
        this.ppg = ppg;
        this.oppg = oppg;
        this.offensiveRating = offensiveRating;
        this.defensiveRating = defensiveRating;
        this.gamesMissed = gamesMissed;
    }

    // Getters and Setters
    public double getWinLossRecord() {
        return winLossRecord;
    }

    public void setWinLossRecord(double winLossRecord) {
        this.winLossRecord = winLossRecord;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getOppg() {
        return oppg;
    }

    public void setOppg(double oppg) {
        this.oppg = oppg;
    }

    public double getOffensiveRating() {
        return offensiveRating;
    }

    public void setOffensiveRating(double offensiveRating) {
        this.offensiveRating = offensiveRating;
    }

    public double getDefensiveRating() {
        return defensiveRating;
    }

    public void setDefensiveRating(double defensiveRating) {
        this.defensiveRating = defensiveRating;
    }

    public double getGamesMissed() {
        return gamesMissed;
    }

    public void setGamesMissed(double gamesMissed) {
        this.gamesMissed = gamesMissed;
    }
}
