package com.example.john.startcutestudio;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
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
public class DisplayFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button monthSelectBtn;
    private PopupWindow mPopWindow;
    private TextView todayPlanDisplay;
    private TextView tomorrowPlanDisplay;
    private Button dateSelector;
    private TextView lastDateShowTxt,dateShowTxt,nextDateShowTxt;
    public DisplayFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_display,container,false);

        lastDateShowTxt = (TextView) view.findViewById(R.id.lastdataShowTextView);
        dateShowTxt = (TextView) view.findViewById(R.id.dataShowTextView);
        nextDateShowTxt = (TextView) view.findViewById(R.id.nextdataShowTextView);
        dateSelector = (Button) view.findViewById(R.id.dateSelectBtn);
        dateSelector.setOnClickListener(this);
        monthSelectBtn = (Button) view.findViewById(R.id.monthSelectBtn);
        monthSelectBtn.setOnClickListener(this);
        todayPlanDisplay = (TextView) view.findViewById(R.id.todayPlanDisplay);
        todayPlanDisplay.setMovementMethod(ScrollingMovementMethod.getInstance());
        tomorrowPlanDisplay = (TextView) view.findViewById(R.id.tomorrowPlanDisplay);
        tomorrowPlanDisplay.setMovementMethod(ScrollingMovementMethod.getInstance());

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.monthSelectBtn:
                showPopupWindow();
                break;
            case R.id.dateSelectBtn:
                dateSelect();
                Toast.makeText(getActivity(), "dateSelect()", Toast.LENGTH_SHORT).show();
                break;
            case R.id.January:
                monthSelectBtn.setText("January");
                Toast.makeText(getActivity(),"January",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.February:
                monthSelectBtn.setText("February");
                Toast.makeText(getActivity(),"February",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.March:
                monthSelectBtn.setText("March");
                Toast.makeText(getActivity(),"March",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.April:
                monthSelectBtn.setText("April");
                Toast.makeText(getActivity(),"April",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.May:
                monthSelectBtn.setText("May");
                Toast.makeText(getActivity(),"May",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.June:
                monthSelectBtn.setText("June");
                Toast.makeText(getActivity(),"June",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.July:
                monthSelectBtn.setText("July");
                Toast.makeText(getActivity(),"July",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.August:
                monthSelectBtn.setText("August");
                Toast.makeText(getActivity(),"August",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.September:
                monthSelectBtn.setText("September");
                Toast.makeText(getActivity(),"September",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.October:
                monthSelectBtn.setText("October");
                Toast.makeText(getActivity(),"October",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.November:
                monthSelectBtn.setText("November");
                Toast.makeText(getActivity(),"November",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.December:
                monthSelectBtn.setText("December");
                Toast.makeText(getActivity(),"December",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            default:
                break;
        }
    }

    private void dateSelect() {
        new AlertDialog.Builder(getActivity()).setTitle("DataSelector").setIcon(android.R.drawable.ic_dialog_info).setSingleChoiceItems(
            new String[] { "1", "2","3", "4","5", "6","7", "8","9", "10","11", "12","13", "14","15", "16","17", "18","19", "20","21", "22","23", "24","25", "26","27", "28","29", "30","31" }, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String a = String.valueOf(which);
                        String b = String.valueOf(which+1);
                        String c = String.valueOf(which+2);
                        if(which == 0){
                            lastDateShowTxt.setText("");
                            dateShowTxt.setText(b);
                            nextDateShowTxt.setText(c);
                        }
                        if(which == 30){
                            lastDateShowTxt.setText(a);
                            dateShowTxt.setText(b);
                            nextDateShowTxt.setText("");
                        }else{
                            lastDateShowTxt.setText(a);
                            dateShowTxt.setText(b);
                            nextDateShowTxt.setText(c);
                        }
                        dialog.dismiss();
                    }
            }).setNegativeButton("取消", null).show();
    }


    private void showPopupWindow() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.monthselect_popupwindow, null);
        mPopWindow = new PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());  //结合构造函数中最后一个参数:“true”等价于mPopWindow.setFocusable(true);设置为点击空白处PopWindow消失
        mPopWindow.setContentView(contentView);
        //显示PopupWindow
        initButton(contentView);
//        View rootview = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_display, null);
        mPopWindow.showAsDropDown(monthSelectBtn,0,20);
    }

    private void initButton( View contentView) {
        Button January = (Button) contentView.findViewById(R.id.January);
        Button February = (Button) contentView.findViewById(R.id.February);
        Button March = (Button) contentView.findViewById(R.id.March);
        Button April = (Button) contentView.findViewById(R.id.April);
        Button May = (Button) contentView.findViewById(R.id.May);
        Button June = (Button) contentView.findViewById(R.id.June);
        Button July = (Button) contentView.findViewById(R.id.July);
        Button August = (Button) contentView.findViewById(R.id.August);
        Button September = (Button) contentView.findViewById(R.id.September);
        Button October = (Button) contentView.findViewById(R.id.October);
        Button November = (Button) contentView.findViewById(R.id.November);
        Button December = (Button) contentView.findViewById(R.id.December);

        January.setOnClickListener(this);
        February.setOnClickListener(this);
        March.setOnClickListener(this);
        April.setOnClickListener(this);
        May.setOnClickListener(this);
        June.setOnClickListener(this);
        July.setOnClickListener(this);
        August.setOnClickListener(this);
        September.setOnClickListener(this);
        October.setOnClickListener(this);
        November.setOnClickListener(this);
        December.setOnClickListener(this);
    }
}
