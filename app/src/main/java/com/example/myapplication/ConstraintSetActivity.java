package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class ConstraintSetActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyframe_one);
        constraintLayout = findViewById(R.id.CL); // member variable

    }
    public void animateToKeyframeTwo(View view) {
       ConstraintSet constraintSet =new  ConstraintSet();
        constraintSet.load(this, R.layout.keyframe_two);
        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet.applyTo(constraintLayout);
    }

}