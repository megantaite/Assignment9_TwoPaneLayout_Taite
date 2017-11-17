package com.example.megan.assignment9_twopanelayout_taite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Megan on 11/2/17.
 */

public class ArchPagerActivity extends AppCompatActivity
        implements ArchListFragment.Callbacks, ArchFragment.Callbacks{
    private ViewPager viewPager;
    private List<Arch> arch;
    public static final String EXTRA_ARCH_ID = "arch_id";

    public static Intent newIntent(Context packageContext, int archId) {
        Intent intent = new Intent(packageContext, ArchPagerActivity.class);
        intent.putExtra(EXTRA_ARCH_ID,archId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch_pager);

        int archId = (int)getIntent().getIntExtra(EXTRA_ARCH_ID,0);

        viewPager = (ViewPager)findViewById(R.id.dater_pager);
        arch = ArchSet.getArchSet().getPeople();

        FragmentManager manager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentPagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return ArchFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return arch.size();
            }
        });

        //initialize the pager begin
        viewPager.setCurrentItem(archId);
    }

    @Override
    public void onArchUpdated(int archId) {

    }

    @Override
    public void onArchSelected(int archId) {

    }
}
