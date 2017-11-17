package com.example.megan.assignment9_twopanelayout_taite;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LaunchFragment();
    }
}
