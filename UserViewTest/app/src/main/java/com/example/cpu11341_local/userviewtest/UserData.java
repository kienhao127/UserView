package com.example.cpu11341_local.userviewtest;

/**
 * Created by CPU11341-local on 8/2/2017.
 */

public class UserData {
    private String UserID;
    private String UserName;
    private Integer ImgSrc;

    public UserData(String userID, String userName, Integer imgSrc) {
        UserID = userID;
        UserName = userName;
        ImgSrc = imgSrc;
    }

    public UserData() {
    }

    public String getUserID() {
        return UserID;
    }

    public Integer getImgSrc() {
        return ImgSrc;
    }

    public String getUserName() {
        return UserName;
    }
}
