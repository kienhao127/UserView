package com.example.cpu11341_local.userviewtest;

/**
 * Created by CPU11341-local on 8/2/2017.
 */

public class VoteData {
    private String UserID;
    private String VoteDate;
    private double Score;

    public VoteData(String userID, String voteDate, double score) {
        UserID = userID;
        VoteDate = voteDate;
        Score = score;
    }

    public double getScore() {
        return Score;
    }

    public String getUserID() {
        return UserID;
    }

    public String getVoteDate() {
        return VoteDate;
    }

}
