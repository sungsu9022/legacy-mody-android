package com.connectu.mody.setting.activity;

/**
 * Created by Bono on 2015-06-13.
 */

class SettingMenu {

    private String menu;
    private String comment;

    public SettingMenu(String menu, String comment){
        this.menu = menu;
        this.comment = comment;
    }

    public String getMenu() {
        return menu;
    }

    public String getComment() {
        return comment;
    }

}
