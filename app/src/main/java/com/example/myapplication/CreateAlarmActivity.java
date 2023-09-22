package com.example.myapplication;

import android.app.ActivityManager;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAlarmActivity extends AppCompatActivity  {
    String[] alarmTitleArray={"第","节","课","下","放学","了","早","中","晚","餐","一","二","三","四","五","六","七","八","九","十","十一","十二",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
    }
    protected void onStart() {
        super.onStart();
        Log.d("CreateAlarmActivity", "onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d("CreateAlarmActivity", "onResume");
    }
    protected void onPause() {
        super.onPause();
        Log.d("CreateAlarmActivity", "onPause");
    }
    protected void onStop() {
        super.onStop();
        Log.d("CreateAlarmActivity", "onStop");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("CreateAlarmActivity", "onRestart");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CreateAlarmActivity", "onDestroy");
    }
    public void createAlarm(String title, int hours, int minutes,boolean isSaturdayWork) throws InterruptedException {

        ArrayList arrayList=new ArrayList();

        arrayList.add(Calendar.MONDAY);
        arrayList.add(Calendar.TUESDAY);
        arrayList.add(Calendar.WEDNESDAY);
        arrayList.add(Calendar.THURSDAY);
        arrayList.add(Calendar.FRIDAY);
        if (isSaturdayWork){
            arrayList.add(Calendar.SATURDAY);
        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, title)
                .putExtra(AlarmClock.EXTRA_HOUR, hours)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                //.putExtra(AlarmClock.EXTRA_RINGTONE,"电子计时器")
                .putExtra(AlarmClock.EXTRA_VIBRATE,true)
                .putExtra(AlarmClock.EXTRA_DAYS,arrayList)
                //.putExtra(AlarmClock.EXTRA_SKIP_UI,false)
                .putExtra(AlarmClock.EXTRA_SKIP_UI,true)
                ;

        startActivity(intent);

        Thread.currentThread().sleep(1500);
        ActivityManager activityManager=getSystemService(ActivityManager.class);
        List<ActivityManager.AppTask> appTaskList=activityManager.getAppTasks();
        appTaskList.get(0).moveToFront();
        Thread.currentThread().sleep(1000);

    }
    public void dismissAlarm()  {

        Intent intent = new Intent(AlarmClock.ACTION_DISMISS_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "title")
                .putExtra(AlarmClock.EXTRA_ALARM_SEARCH_MODE,AlarmClock.ALARM_SEARCH_MODE_LABEL)
                //.putExtra(AlarmClock.EXTRA_ALARM_SEARCH_MODE, "android.label")
                ;

        startActivity(intent);
    }
    public void snoozeAlarm()  {

        Intent intent = new Intent(AlarmClock.ACTION_SNOOZE_ALARM)
                .putExtra(AlarmClock.EXTRA_ALARM_SNOOZE_DURATION, 5)
                ;

        startActivity(intent);
    }

    public int[] getTime(){
        int[] intArray=new int[5];
        String strSunsetTime_HOURS=((EditText) findViewById(R.id.SunsetTime_HOURS)).getText().toString();
        StringToIntTypeCast stringToIntTypeCast=new StringToIntTypeCast(strSunsetTime_HOURS);
        int SunsetTime_HOURS=stringToIntTypeCast.intA;
        String strSunsetTime_MINUTES=((EditText) findViewById(R.id.SunsetTime_MINUTES)).getText().toString();
        StringToIntTypeCast stringToIntTypeCast_1=new StringToIntTypeCast(strSunsetTime_MINUTES);
        int SunsetTime_MINUTES=stringToIntTypeCast_1.intA;
        String strbreakfastTime=((EditText) findViewById(R.id.breakfast)).getText().toString();
        StringToIntTypeCast stringToIntTypeCast_2=new StringToIntTypeCast(strbreakfastTime);
        int breakfastTime=stringToIntTypeCast_2.intA;
        String strrestTime=((EditText) findViewById(R.id.restTime)).getText().toString();
        StringToIntTypeCast stringToIntTypeCast_3=new StringToIntTypeCast(strrestTime);
        int restTime=stringToIntTypeCast_3.intA;
        String strsunsetOffsetTime=((EditText) findViewById(R.id.sunsetOffsetTime)).getText().toString();
        StringToIntTypeCast stringToIntTypeCast_4=new StringToIntTypeCast(strsunsetOffsetTime);
        int sunsetOffsetTime=stringToIntTypeCast_4.intA;
        intArray[0]=SunsetTime_HOURS;
        intArray[1]=SunsetTime_MINUTES;
        intArray[2]=breakfastTime;
        intArray[3]=restTime;
        intArray[4]=sunsetOffsetTime;
        return  intArray;
    }
    public boolean getisSaturdayWork(){
        CheckBox checkBox=((CheckBox) findViewById(R.id.SATURDAY));
        return checkBox.isChecked();
    }
    public void computeTime(int SunsetTime_HOURS, int SunsetTime_MINUTES,int breakfastTime,int restTime,int sunsetOffsetTime,boolean isSaturdayWork) throws InterruptedException {
        int SunsetTime_HOURS_1=SunsetTime_HOURS;
        int SunsetTime_MINUTES_1=SunsetTime_MINUTES;
        for (int i = 23; i >= -1; i--) {
            if(i==23){
                Log.d("i:", String.valueOf(i));
                if(SunsetTime_MINUTES_1>=sunsetOffsetTime){
                    SunsetTime_MINUTES_1=SunsetTime_MINUTES_1-sunsetOffsetTime;
                    createAlarm(alarmTitleArray[4]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork );
                    Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                    Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                }
                else{
                    SunsetTime_HOURS_1=SunsetTime_HOURS_1-1;
                    SunsetTime_MINUTES_1=SunsetTime_MINUTES_1+60-sunsetOffsetTime;
                    createAlarm(alarmTitleArray[4]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork  );
                    Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                    Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                }
            }
            else{
                if(i==11){
                    Log.d("i11:", String.valueOf(i));
                    if(SunsetTime_MINUTES_1>=restTime){
                        SunsetTime_MINUTES_1=SunsetTime_MINUTES_1-restTime;
                        createAlarm(alarmTitleArray[0]+alarmTitleArray[15]+alarmTitleArray[1]+alarmTitleArray[2]+alarmTitleArray[3]+alarmTitleArray[2]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1 ,isSaturdayWork );
                        Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                        Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                    }
                    else{
                        SunsetTime_HOURS_1=SunsetTime_HOURS_1-1;
                        SunsetTime_MINUTES_1=SunsetTime_MINUTES_1+60-restTime;
                        createAlarm(alarmTitleArray[0]+alarmTitleArray[15]+alarmTitleArray[1]+alarmTitleArray[2]+alarmTitleArray[3]+alarmTitleArray[2]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1 ,isSaturdayWork );
                        Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                        Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                    }
                }
                else{
                    if(i==-1){
                        Log.d("i:", String.valueOf(i));
                        if(SunsetTime_MINUTES_1>=breakfastTime){
                            SunsetTime_MINUTES_1=SunsetTime_MINUTES_1-breakfastTime;
                            createAlarm( alarmTitleArray[6]+alarmTitleArray[9],SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1 ,isSaturdayWork );
                            Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                            Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                        }
                        else{
                            SunsetTime_HOURS_1=SunsetTime_HOURS_1-1;
                            SunsetTime_MINUTES_1=SunsetTime_MINUTES_1+60-breakfastTime;
                            createAlarm(alarmTitleArray[6]+alarmTitleArray[9], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork  );
                            Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                            Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                        }

                        Toast.makeText(this,"CreateAlarm Completed.", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        if(i%2==0){
                            Log.d("i:", String.valueOf(i));
                            if(SunsetTime_MINUTES_1>=40){
                                SunsetTime_MINUTES_1=SunsetTime_MINUTES_1-40;
                                createAlarm(alarmTitleArray[0]+alarmTitleArray[i/2+10]+alarmTitleArray[1]+alarmTitleArray[2], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork  );
                                Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                                Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                            }
                            else{
                                SunsetTime_HOURS_1=SunsetTime_HOURS_1-1;
                                SunsetTime_MINUTES_1=SunsetTime_MINUTES_1+20;
                                createAlarm(alarmTitleArray[0]+alarmTitleArray[i/2+10]+alarmTitleArray[1]+alarmTitleArray[2], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork  );
                                Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                                Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                            }
                        }
                        else{
                            Log.d("i:", String.valueOf(i));
                            if(SunsetTime_MINUTES_1>=10){
                                SunsetTime_MINUTES_1=SunsetTime_MINUTES_1-10;
                                createAlarm(alarmTitleArray[0]+alarmTitleArray[(i+1)/2+9]+alarmTitleArray[1]+alarmTitleArray[2]+alarmTitleArray[3]+alarmTitleArray[2]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1 ,isSaturdayWork );
                                Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                                Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                            }
                            else{
                                SunsetTime_HOURS_1=SunsetTime_HOURS_1-1;
                                SunsetTime_MINUTES_1=SunsetTime_MINUTES_1+50;
                                createAlarm(alarmTitleArray[0]+alarmTitleArray[(i+1)/2+9]+alarmTitleArray[1]+alarmTitleArray[2]+alarmTitleArray[3]+alarmTitleArray[2]+alarmTitleArray[5], SunsetTime_HOURS_1 ,SunsetTime_MINUTES_1,isSaturdayWork  );
                                Log.d("SunsetTime_HOURS_1:", String.valueOf(SunsetTime_HOURS_1));
                                Log.d("SunsetTime_MINUTES_1:", String.valueOf(SunsetTime_MINUTES_1));
                            }
                        }

                    }
                }

            }

        }

    }
    public void sendMessage(View view) throws IOException, InterruptedException, SAXException {

        computeTime(getTime()[0], getTime()[1], getTime()[2], getTime()[3],getTime()[4], getisSaturdayWork());

    }
}