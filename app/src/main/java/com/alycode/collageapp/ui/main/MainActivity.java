package com.alycode.collageapp.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alycode.collageapp.R;
import com.alycode.collageapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.firstLevelBtn.setOnClickListener(this);
        mainBinding.secLevelBtn.setOnClickListener(this);
        mainBinding.thirdLevelBtn.setOnClickListener(this);
        mainBinding.fourthLevelBtn.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_level_btn:
            case R.id.sec_level_btn:
            case R.id.fourth_level_btn: {
                Toast.makeText(MainActivity.this, "سوف يتم اضافه ملفات هنا قريبا", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.third_level_btn: {
                Intent intent = new Intent(MainActivity.this, BaseActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}