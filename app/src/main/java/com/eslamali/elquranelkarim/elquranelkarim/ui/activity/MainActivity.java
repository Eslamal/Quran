package com.eslamali.elquranelkarim.elquranelkarim.ui.activity;

import android.os.Bundle;

import com.eslamali.elquranelkarim.elquranelkarim.helper.HelperMethod;
import com.eslamali.elquranelkarim.elquranelkarim.ui.fragment.homeCycle.ContinerFragment;
import com.eslamali.elquranelkarim.R;

public class MainActivity extends BaseActivity {
    private static final long SPLASH_DISPLAY_LENGTH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                *//* Create an Intent that will start the Menu-Activity. *//*
                replaceFragment(getSupportFragmentManager(), R.id.main_activity_frame_layout_id, new ContinerFragment());
            }
        }, SPLASH_DISPLAY_LENGTH);*/
        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.main_activity_frame_layout_id, new ContinerFragment());

    }
}