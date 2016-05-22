package com.example.john.startcutestudio;

import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.efan.basecmlib.activity.BaseActivity;
import com.efan.basecmlib.annotate.ContentView;

/**
 * Created by john on 2016/4/5.
 */
@ContentView(id = R.layout.activity_register)
public class RegisterActivity extends BaseActivity{

    private Button btn_reg_startMainActivity;
    private long firstTime = 0;

    @Override
    public void initView() {
        btn_reg_startMainActivity = (Button) findViewById(R.id.btn_reg_save);
        btn_reg_startMainActivity.setOnClickListener(this);
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
            case R.id.btn_reg_save:
                Intent intent_startMainActivity = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent_startMainActivity);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                this.finish();
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            this.finish();
            overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
        }
        return super.onKeyDown(keyCode, event);
    }
}
