package com.example.myapplication;

import static android.location.LocationManager.KEY_PROXIMITY_ENTERING;

import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class method {
    public method(){

        //getCurrentFocus();
        //ImageView imageView= findViewById("imageView2");
        /*Intent intent = new Intent(this, DisplayMessageActivity.class);
          EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
          String message = editText.getText().toString();
          intent.putExtra(EXTRA_MESSAGE, message);
          startActivity(intent);*/
        //new ActivityResultContracts.OpenDocument();
       /* file.getFreeSpace();
          file.getTotalSpace();*/
        /*content://media/external/images/media
        /storage/emulated/0/Pictures/
        /storage/emulated/0/Pictures/IMG_20221216_141652.jpg
        String strImages="/media/external/images/media";
        String strImages="media//external//images//media";
        String strImages="//media//external//images//media";
        File file=new File(strImages+"/new image_2.jpg");*/

        /*true*/
        /*Intent intent=new Intent();
        intent.setClass(getApplicationContext(),MainActivity1.class);
        startActivity(intent);*/

        /*Intent intent=new Intent();
        intent.setClassName("com.example.myapplication","MainActivity2.class");
        startActivity(intent);*/

        /*Log.d(" getMaxShortcutCountPerActivity", String.valueOf(getMaxShortcutCountPerActivity(getApplicationContext())));*/

        //非必要添加,只setAction,即可调用其它应用窗口.
        //非必要添加,只setType,无法调用其它应用窗口.会返回主窗口.
        //非必要添加,只setAction和addCategory,即可调用其它应用窗口.只addCategory,无法调用其它应用窗口.

        /*intent.setAction(Intent.ACTION_WEB_SEARCH);
        intent.putExtra("QUERY","QUERY");*/

        /*intent.setAction(Intent.ACTION_CALL);
        intent.putExtra("QUERY","QUERY");*/

        //intent.setType("text/plain");
        //intent.setType("image/png");

        /*intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_WEATHER);
        startActivity(intent);*/

        /*String[] stringArray={"0","1","2"};
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(ImageViewInListViewActivity.this, android.R.layout.simple_list_item_1,stringArray);
        listView.setAdapter(imageViewArrayAdapter);*/
        //Log.d("AccessLocationActivity_1:", String.valueOf(locationManager.isLocationEnabled()));
        /*Executor executor =new Executor() {
            @Override
            public void execute(Runnable runnable) {

            }
        };*/
         /* for (int i = 0; i <locationManager.getProviders(true).size() ; i++) {
            Log.d("Providers_" + i + ":", locationManager.getProviders(true).get(i));

        }*/
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            locationManager.getProviderProperties("network");
        }*/
        /*Button button16= findViewById(R.id.button16);
        button16.performClick();*/
        /*public int onStartCommand(Intent intent, int flags, int startId) {

        *//*if(i==0){
       location =  intent.getParcelableExtra("location");}
        i++;
        Log.d("RequestLocationUpdatesService:", String.valueOf(location.distanceTo(intent.getParcelableExtra("location"))));*//*


            //Log.d("RequestLocationUpdatesService:", "getLatitude():"+location.getLatitude()+",getLongitude():"+location.getLongitude());
            //Log.d("RequestLocationUpdatesService:", String.valueOf(intent.getParcelableExtra("KEY_PROXIMITY_ENTERING")));
            //Log.d("RequestLocationUpdatesService:", String.valueOf(intent.getBooleanExtra("KEY_PROXIMITY_ENTERING",false)));


            Log.d("RequestLocationUpdatesService:" , String.valueOf(intent.getBooleanExtra(KEY_PROXIMITY_ENTERING,false)));

            return  START_STICKY;
        }*/
        /*app:layout_constraintHorizontal_weight="5"*/
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }*/

    }
}
