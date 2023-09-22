package com.example.myapplication;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;

public class MyLocationListener extends BDAbstractLocationListener {
    @Override
    public void onReceiveLocation(BDLocation location){
        //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
        //以下只列举部分获取地址相关的结果信息
        //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

        String addr = location.getAddrStr();    //获取详细地址信息
        Log.d("MyLocationListener:",addr );
        String country = location.getCountry();    //获取国家
        String province = location.getProvince();    //获取省份

        String city = location.getCity();    //获取城市
        Log.d("MyLocationListener:",city );
        String district = location.getDistrict();    //获取区县
        Log.d("MyLocationListener:",district );
        String street = location.getStreet();    //获取街道信息
        Log.d("MyLocationListener:",street );
        String adcode = location.getAdCode();    //获取adcode
        Log.d("MyLocationListener:",adcode );
        String town = location.getTown();    //获取乡镇信息
        Log.d("MyLocationListener:",town );
        double  Altitude= location.getAltitude();
        Log.d("MyLocationListener_Altitude:", String.valueOf(Altitude));
        /*String  BuildingID=location.getBuildingID();
        Log.d("MyLocationListener_BuildingID:",BuildingID );*/

        String  CoorType=location.getCoorType();
        Log.d("MyLocationListener_CoorType:",CoorType );

        long  DelayTime=location.getDelayTime();
        Log.d("MyLocationListener_DelayTime:", String.valueOf(DelayTime));

        float  Direction=location.getDirection();
        Log.d("MyLocationListener_Direction:", String.valueOf(Direction));


        /*String  Floor=location.getFloor();
        Log.d("MyLocationListener_Floor:",Floor );*/

        int   	GnssAccuracyStatus=location.getGnssAccuracyStatus();
        Log.d("MyLocationListener_GnssAccuracyStatus():", String.valueOf(GnssAccuracyStatus));

        double   	Latitude=location. 	getLatitude();
        Log.d("MyLocationListener_Latitude:", String.valueOf(Latitude));


        float  	Radius=location.getRadius() 	;
        Log.d("MyLocationListener_Radius:", String.valueOf(Radius));

        String  	Time=location.getTime() 	;
        Log.d("MyLocationListener_Time:", Time);

        /*String  	Traffic=location .	getTraffic() 	;
        Log.d("MyLocationListener_Traffic:",Traffic );*/

        int  	isTrafficStation=location .	isTrafficStation()	;
        Log.d("MyLocationListener_isTrafficStation:", String.valueOf(isTrafficStation));

        String locationDescribe = location.getLocationDescribe();
        Log.d("MyLocationListener_locationDescribe:", locationDescribe);
        String[] stringArray={"0","1","2"};
        /*ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stringArray);
        ListView listView= findViewById(R.id.poi);
        listView.setAdapter(stringArrayAdapter);
        for (int i = 0; i < location.getPoiList().size(); i++) {
            Poi poi = location.getPoiList().get(i);
            String poiName = poi.getName();    //获取POI名称
            Log.d("MyLocationListener_poiName:", poiName);
            //String poiTags = poi.getTag();    //获取POI类型
            String poiAddr = poi.getAddr();    //获取POI地址 //获取周边POI信息
            Log.d("MyLocationListener_poiAddr:",poiAddr );
        }*/

    }
}
