package com.connectu.mody.main.model;

/**
 * Created by Bono on 2015-06-13.
 */

public class Mody {

    private String modyName;
    private String userInfo;
    private int photo;

    public Mody(String modyName, String userInfo, int photo) {
        this.modyName = modyName;
        this.userInfo = userInfo;
        this.photo = photo;
    }

    public String getModyName() {
        return modyName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public int getPhotoId() {
        return photo;
    }

}
