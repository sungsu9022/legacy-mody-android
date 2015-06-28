package com.connectu.mody.category.activity;

import android.app.Activity;
import android.os.Bundle;

import com.connectu.mody.R;
import com.connectu.mody.category.model.CategoryTypeEnum;

public class SelectCategoryActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        CategoryTypeEnum[] categoryTypeEnums = CategoryTypeEnum.values();



    }

}