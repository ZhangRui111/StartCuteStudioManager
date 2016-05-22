package com.example.john.startcutestudio;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by john on 2016/4/13.
 */
public class GroupTaskFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button groupSelectBtn,nameSelectorBtn;
    private TextView todayPlanDisplay;
    private TextView tomorrowPlanDisplay;
    private TextView nameShowTxt;

    public GroupTaskFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_grouptask,container,false);

        nameSelectorBtn = (Button) view.findViewById(R.id.selectNameBtn);
        nameSelectorBtn.setOnClickListener(this);
        nameShowTxt = (TextView) view.findViewById(R.id.nameShowTextView);
        groupSelectBtn = (Button) view.findViewById(R.id.groupSelectBtn);
        groupSelectBtn.setOnClickListener(this);
        todayPlanDisplay = (TextView) view.findViewById(R.id.todayPlanDisplay);
        todayPlanDisplay.setMovementMethod(ScrollingMovementMethod.getInstance());
        tomorrowPlanDisplay = (TextView) view.findViewById(R.id.tomorrowPlanDisplay);
        tomorrowPlanDisplay.setMovementMethod(ScrollingMovementMethod.getInstance());

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.groupSelectBtn:
                Toast.makeText(getActivity(),groupSelectBtn.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.selectNameBtn:
                nameSelect();
                break;
        }
    }

    private void nameSelect() {
        new AlertDialog.Builder(getActivity()).setTitle("Welcome").setIcon(android.R.drawable.ic_dialog_info).setSingleChoiceItems(
                new String[] {"巨总" ,"董阔","张瑞","莫生","DKK","骜宝宝","胡荣","胡赛军",}, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0:
                                nameShowTxt.setText("巨总");
                                break;
                            case 1:
                                nameShowTxt.setText("董阔");
                                break;
                            case 2:
                                nameShowTxt.setText("张瑞");
                                break;
                            case 3:
                                nameShowTxt.setText("莫生");
                                break;
                            case 4:
                                nameShowTxt.setText("DKK");
                                break;
                            case 5:
                                nameShowTxt.setText("骜宝宝");
                                break;
                            case 6:
                                nameShowTxt.setText("胡荣");
                                break;
                            case 7:
                                nameShowTxt.setText("胡赛军");
                                break;
                        }
                        dialog.dismiss();
                    }
                }).setNegativeButton("取消", null).show();
    }
}

