package com.example.john.startcutestudio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by john on 2016/4/13.
 */
public class ReleaseFragment extends android.app.Fragment implements View.OnClickListener {

    private ImageButton editTodayPlanImageBtn;
    private EditText editTodayPlanEditText;
    private ImageButton editTomorrowPlanImageBtn;
    private EditText editTomorrowPlanEditView;
    private Button saveBtn;
    private View view;
    private String todayPlan,tomorrowPlan;

    public ReleaseFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_release,container,false);

        editTodayPlanImageBtn = (ImageButton) view.findViewById(R.id.editIcon1ImageButton);
        editTodayPlanEditText = (EditText) view.findViewById(R.id.editTodayPlan);
        editTomorrowPlanImageBtn = (ImageButton) view.findViewById(R.id.editIcon2ImageButton);
        editTomorrowPlanEditView = (EditText) view.findViewById(R.id.editTomorrowPlan);
        saveBtn = (Button) view.findViewById(R.id.saveBtn);

        editTodayPlanImageBtn.setOnClickListener(this);
        editTomorrowPlanImageBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editIcon1ImageButton:
                editTodayPlanEditText.requestFocus();
                Toast.makeText(getActivity(),"请输入今日计划",Toast.LENGTH_SHORT).show();
                break;
            case R.id.editIcon2ImageButton:
                editTomorrowPlanEditView.requestFocus();
                Toast.makeText(getActivity(),"请输入明日计划",Toast.LENGTH_SHORT).show();
                break;
            case R.id.saveBtn:
                todayPlan = editTodayPlanEditText.getText().toString();
//                Toast.makeText(getActivity(),todayPlan,Toast.LENGTH_SHORT).show();
                tomorrowPlan = editTomorrowPlanEditView.getText().toString();
//                Toast.makeText(getActivity(),tomorrowPlan,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}