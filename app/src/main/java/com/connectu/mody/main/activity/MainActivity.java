package com.connectu.mody.main.activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.connectu.mody.R;
import com.connectu.mody.category.activity.SelectCategoryActivity;
import com.connectu.mody.main.model.Mody;
import com.connectu.mody.setting.activity.SettingActivity;
import com.connectu.mody.specificview.activity.SpecificViewActivity;

import java.util.ArrayList;


public class MainActivity extends ListActivity {
    private ImageButton settingButton;
    private ImageButton addCategoryButton;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        settingButton = (ImageButton)findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
        
        //
        addCategoryButton = (ImageButton)findViewById(R.id.add_category_button);
        addCategoryButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SelectCategoryActivity.class));
            }
        });

        // Mody List
        ArrayList<Mody> modyList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Mody mody = new Mody("Make a Party Tonight!","Dongwon Lee", 0);
            modyList.add(mody);
        }

        mListView = (ListView) findViewById(android.R.id.list);
        //mListView = getListView();
        mListView.setAdapter(new ModyAdapter(this, R.layout.item_row, modyList));
        mListView.setOnItemClickListener(mItemClickListener);

    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long l_position)
        {
            startActivity(new Intent(MainActivity.this, SpecificViewActivity.class));
        }
    };


    private class ModyAdapter extends ArrayAdapter<Mody> {

        private ArrayList<Mody> modies;

        public ModyAdapter(Context context, int textViewResourceId, ArrayList<Mody> modies) {
            super(context, textViewResourceId, modies);
            this.modies = modies;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.mody_row, null);
            }
            Mody mody = modies.get(position);
            if (mody != null) {
                TextView topText = (TextView) v.findViewById(R.id.toptext);
                TextView bottomText = (TextView) v.findViewById(R.id.bottomtext);
                ImageView photo = (ImageView) v.findViewById(R.id.photo);
                int photoId = mody.getPhotoId();
                if (topText != null) {
                    topText.setText(mody.getModyName());
                }
                if (bottomText != null) {
                    bottomText.setText(mody.getUserInfo());
                }
                if (photoId != 0) {
                    ((ImageView) v.findViewById(R.id.photo)).setImageResource(mody.getPhotoId());
                }
                /*else {
                    ((ImageView)v.findViewById(R.id.photo)).setImageResource(R.drawable.nophoto);
                }*/
            }
            return v;
        }

    }
}