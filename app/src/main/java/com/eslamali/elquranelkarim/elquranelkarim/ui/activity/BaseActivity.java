package com.eslamali.elquranelkarim.elquranelkarim.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.eslamali.elquranelkarim.elquranelkarim.ui.fragment.BaseFragment;


public class BaseActivity extends AppCompatActivity {
     public BaseFragment baseFragment;

    @Override
    public void onBackPressed() {
        baseFragment.BackPressed();
    }
    public void superOnBackPressed(){
        super.onBackPressed();
    }
}
