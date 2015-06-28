package com.connectu.mody.setting.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.connectu.mody.R;
import com.connectu.mody.main.activity.MainActivity;

import java.util.ArrayList;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        String[] settingList = getResources().getStringArray(R.array.settingList);
        String[] settingCommentList = getResources().getStringArray(R.array.settingCommentList);

        int menuLength = (settingList.length + settingCommentList.length)/2;

        ArrayList<SettingMenu> settingMenuList = new ArrayList<>();

        for(int i = 0; i < menuLength; i++) {
            SettingMenu menu = new SettingMenu(settingList[i], settingCommentList[i]);
            settingMenuList.add(menu);
        }

        SettingAdapter settingAdapter = new SettingAdapter(this, R.layout.item_row, settingMenuList);
        setListAdapter(settingAdapter);
    }

    private class SettingAdapter extends ArrayAdapter<SettingMenu> {

        private ArrayList<SettingMenu> items;

        public SettingAdapter(Context context, int textViewResourceId, ArrayList<SettingMenu> items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_row, null);
            }
            SettingMenu menu = items.get(position);
            if (menu != null) {
                TextView topText = (TextView) v.findViewById(R.id.toptext);
                TextView bottomText = (TextView) v.findViewById(R.id.bottomtext);
                if (topText != null){
                    topText.setText(menu.getMenu());
                }
                if(bottomText != null){
                    bottomText.setText(menu.getComment());
                }
            }
            v.setOnClickListener(new Button.OnClickListener(){
                public void onClick(View v){
                    dialogSelectOption();
                }
            });

            return v;
        }

        private void dialogSelectOption() {
            final String items[] = { "item1", "item2", "item3" };
            AlertDialog.Builder ab = new AlertDialog.Builder(SettingActivity.this);
            ab.setTitle("Title");
            ab.setSingleChoiceItems(items, 0,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            //
                        }

                    }).setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                              // ok
                        }
                    }).setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // cancel
                        }
                    });
            ab.show();
        }
    }
}