package com.connectu.mody.main.activity;
//package com.connectu.mody.setting.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.connectu.mody.R;
import com.connectu.mody.setting.activity.SettingActivity;


public class MainActivity extends Activity {

    ImageButton settingButton;
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // xml�� �ҷ��� �̹̺並 bt�� �־� �Ӽ���� �ϱ����� ����
        settingButton = (ImageButton)findViewById(R.id.setting_button);
        // ��ư�� Ŭ���̺�Ʈ ó��
        //bt.setOnClickListener((OnClickListener) this);

        settingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
    }

    /*@Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.setting_button:
                // �̹����信 ������ ����ϴ� ����
                iv.setImageResource(R.drawable.main_setting_icon);
                // �ؽ�Ʈ�信 ���ڿ� ����ϴ� ����
                tv.setText("setting");
                break;
        }
    }*/
}
