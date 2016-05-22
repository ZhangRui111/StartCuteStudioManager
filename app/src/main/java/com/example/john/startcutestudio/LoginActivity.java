package com.example.john.startcutestudio;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.efan.basecmlib.activity.BaseActivity;
import com.efan.basecmlib.annotate.ContentView;

/**
   Created by john on 2016/4/5.
 */

@ContentView(id = R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    private Button btn_login_reg;
    private Button btn_login_log;
    private long firstTime = 0;

    @Override
    public void initView() {
        btn_login_log = (Button) findViewById(R.id.btn_login);
        btn_login_reg = (Button) findViewById(R.id.btn2_login);
        btn_login_log.setOnClickListener(this);
        btn_login_reg.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent intent_startMainActivity = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent_startMainActivity);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                this.finish();
                break;
            case R.id.btn2_login:
                Intent intent_startRegisterActivity = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent_startRegisterActivity);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-firstTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
