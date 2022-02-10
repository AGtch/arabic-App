package com.alycode.collageapp.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alycode.collageapp.FireBaseHandle.ContextProvider;
import com.alycode.collageapp.R;
import com.alycode.collageapp.ui.fragment.SemesterFragment;

public class BaseActivity extends AppCompatActivity {

    public static BaseActivity newInstanceFromBaseActivity() {
        return new BaseActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ContextProvider.setContext(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .add(R.id.fragment_container_view, SemesterFragment.class, null)
                    .commit();
        }

    }
}