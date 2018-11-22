package com.gbz.datepicker;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;
    private Calendar cal;
    private int year,month,day,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //获取日历的一个对象
        cal = Calendar.getInstance();
        //获取年月日时分秒的信息
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);
        datePicker=(DatePicker) findViewById(R.id.datePicker1);
        timePicker=(TimePicker) findViewById(R.id.timePicker1);

        //DatePicker 初始化
        //DatePicker.init(year,cal.get(Calendar.MONTH),day,new DatePicker.OnDateChangedListener(){
        datePicker.init(year,cal.get(Calendar.MONTH),day,new OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        });

        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

            @Override
            public void onTimeChanged(TimePicker view,int hourOfDay,int minute){
                setTitle(hourOfDay+":"+minute);
            }
        });

//        new DatePickerDialog(this, new OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
//            }
//        },year,cal.get(Calendar.MONTH),day).show();

        new TimePickerDialog(this, new OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay+":"+minute);
            }
        },hour,minute,true).show();
    }
}
