package com.example.cpu11341_local.userviewtest;

/**
 * Created by CPU11341-local on 8/3/2017.
 */

public class ViewTimeData {
    private String UserID;
    private String ViewDate;
    private int ShowTime;
    private int PCTime;
    private int MobileTime;
    private int OtherTime;

    public ViewTimeData(String userID, String viewDate, int showTime, int pcTime, int mobileTime, int otherTime) {
        UserID = userID;
        ViewDate = viewDate;
        ShowTime = showTime;
        PCTime = pcTime;
        MobileTime = mobileTime;
        OtherTime = otherTime;
    }

    public String getUserID() {
        return UserID;
    }

    public int getMobileTime() {
        return MobileTime;
    }

    public int getOtherTime() {
        return OtherTime;
    }

    public int getPCTime() {
        return PCTime;
    }

    public int getShowTime() {
        return ShowTime;
    }

    public String getViewDate() {
        return ViewDate;
    }
}
