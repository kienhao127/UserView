package com.example.cpu11341_local.userviewtest;

/**
 * Created by CPU11341-local on 8/1/2017.
 */

public class Dataprovider {
    private int img_res;
    private String item_name;

    public Dataprovider(int img_res, String item_name) {
        this.setImg_res(img_res);
        this.getItemName(item_name);
    }

    public int getImg_res() {
        return img_res;
    }

    public String getItemName() {
        return item_name;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public void getItemName(String item_name) {
        this.item_name = item_name;
    }
}
