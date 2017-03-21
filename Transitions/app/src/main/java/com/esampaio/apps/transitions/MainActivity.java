package com.esampaio.apps.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity {
    private Scene scene1,scene2;
    private Transition transition;
    private boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup baseLayout = (ViewGroup) findViewById(R.id.base);
        View startLayout = LayoutInflater.from(this).inflate(R.layout.activity_main, baseLayout, false);
        View endLayout = LayoutInflater.from(this).inflate(R.layout.end_layout, baseLayout, false);
        scene1 = new Scene(baseLayout,startLayout);
        scene2 = new Scene(baseLayout,endLayout);

        transition = new android.transition.Fade();
        transition.setDuration(500);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());

        start = false;
    }

    public void changeScene(View v){

        if(start) {
            TransitionManager.go(scene2, transition);
            start=false;
        }
        else {
            TransitionManager.go(scene1, transition);
            start=true;
        }
    }
}
