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
        // xml에 불러온 이미뷰를 bt에 넣어 속성사용 하기위한 구문
        settingButton = (ImageButton)findViewById(R.id.setting_button);
        // 버튼에 클릭이벤트 처리
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
                // 이미지뷰에 사진을 출력하는 구문
                iv.setImageResource(R.drawable.main_setting_icon);
                // 텍스트뷰에 문자열 출력하는 구문
                tv.setText("setting");
                break;
        }
    }*/
}
