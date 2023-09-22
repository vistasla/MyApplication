package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class ImplementOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implement_order);
    }
    public void onClick (View view) throws IOException {
        method_1 ();
        Log.d("onClick:", "");

    }
    public void method ()  {

        //Log.d(this.toString(),"8");
        Intent intent=new Intent(this,ImplementOrderService.class);
        startService(intent);

    }
    public boolean method_1 ()  {
        Intent intent=new Intent(this,ImplementOrderService.class);
        startService(intent);

return true;
    }
    public void  method_2()  {

    }

}