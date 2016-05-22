package com.example.john.startcutestudio;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by john on 2016/5/16.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button logOffBtn,modifyPasswordBtn;

    public SettingFragment(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting,container,false);
        logOffBtn = (Button) view.findViewById(R.id.logoffBtn);
        logOffBtn.setOnClickListener(this);
        modifyPasswordBtn = (Button) view.findViewById(R.id.modifyPasswordBtn);
        modifyPasswordBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.modifyPasswordBtn:
                Intent backtoModify = new Intent(getActivity(),ModifyPasswordActivity.class);
                startActivity(backtoModify);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
                break;
            case R.id.logoffBtn:
                Intent backtoLog = new Intent(getActivity(),LoginActivity.class);
                startActivity(backtoLog);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
                break;
            default:
                break;
        }
    }
}
