package com.connectu.mody.main.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.connectu.mody.R;
import com.connectu.mody.setting.activity.SettingActivity;
import java.util.ArrayList;


public class MainActivity extends ListActivity {
    ImageButton settingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingButton = (ImageButton)findViewById(R.id.setting_button);

        settingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

        ArrayList<Mody> modyList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Mody mody = new Mody("Make a Party Tonight!","Dongwon Lee", 0);
            modyList.add(mody);
        }

        ModyAdapter modyAdapter = new ModyAdapter(this, R.layout.item_row, modyList);
        setListAdapter(modyAdapter);
    }

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
                if (topText != null){
                    topText.setText(mody.getModyName());
                }
                if(bottomText != null){
                    bottomText.setText(mody.getUserInfo());
                }
                if (photoId != 0) {
                    ((ImageView)v.findViewById(R.id.photo)).setImageResource(mody.getPhotoId());
                }
                /*else {
                    ((ImageView)v.findViewById(R.id.photo)).setImageResource(R.drawable.nophoto);
                }*/
            }
            return v;
        }
    }
}
