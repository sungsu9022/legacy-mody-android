package com.connectu.mody.specificview.activity;

/**
 * Created by honggul87 on 2015-06-28.
 */

class SpecificView {

    private String title;
    private String comment;

    public SpecificView(String menu, String comment){
        this.title = menu;
        this.comment = comment;
    }

    public String gettitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

}
