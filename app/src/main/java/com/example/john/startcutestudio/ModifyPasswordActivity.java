package com.example.john.startcutestudio;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by john on 2016/5/17.
 */
public class ModifyPasswordActivity extends Activity implements View.OnClickListener {

    private Button saveChangeBtn,cancelChangeBtn;
    private EditText oldPassword,newPassword,checkNewPassword;
    public String newPasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifypassword);

        initUI();
    }

    private void initUI() {
        saveChangeBtn = (Button) findViewById(R.id.saveModifyAtyBtn);
        saveChangeBtn.setOnClickListener(this);
        cancelChangeBtn = (Button) findViewById(R.id.cancelModifyAtyBtn);
        cancelChangeBtn.setOnClickListener(this);
        oldPassword = (EditText) findViewById(R.id.oldPasswordEditText);
        newPassword = (EditText) findViewById(R.id.newPasswordEditText);
        checkNewPassword = (EditText) findViewById(R.id.checkNewPasswordEditText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveModifyAtyBtn:
                checkChange();
                break;
            case R.id.cancelModifyAtyBtn:
                Intent backtoMain = new Intent(getApplication(),MainActivity.class);
                startActivity(backtoMain);
                this.finish();
                overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
                break;
            default:
                break;
        }
    }

    private void checkChange() {
        String str1,str2,str3;
        str1 = oldPassword.getText().toString();
        str2 = newPassword.getText().toString();
        str3 = checkNewPassword.getText().toString();

        if(str1.equals("cm")){
            if(str2.equals(str3)){
                /**
                 * 在这里修改密码
                 */
                Toast.makeText(ModifyPasswordActivity.this, "修改密码成功", Toast.LENGTH_SHORT).show();
                Intent backtolog = new Intent(getApplication(),LoginActivity.class);
                startActivity(backtolog);
                this.finish();
                overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
            }else{
                Toast.makeText(ModifyPasswordActivity.this, "两次输入新密码不一致！", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(ModifyPasswordActivity.this, "旧密码错误！", Toast.LENGTH_SHORT).show();
        }
    }
}
