package com.example.megan.assignment9_twopanelayout_taite;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Megan on 11/2/17.
 */

public class ArchListActivity extends SingleFragmentActivity
    implements ArchListFragment.Callbacks, ArchFragment.Callbacks{

    @Override
    protected Fragment createFragment() {
        return new ArchListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_master_layout;
    }

    @Override
    public void onArchSelected(int archId) {
        //rxn is dif. for portrait vs. land

        //portrait
        if(findViewById(R.id.details_fragment_container) == null){
            Intent intent = ArchPagerActivity.newIntent(this, archId);
            startActivity(intent);
        }
        else{   //landscape or tablet
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment oldFragment = manager.findFragmentById(R.id.details_fragment_container);
            Fragment newFragment = ArchFragment.newInstance(archId);

            if(oldFragment != null){
                transaction.remove(oldFragment);
            }

            transaction.add(R.id.details_fragment_container, newFragment);
            transaction.commit();
        }
    }

    @Override
    public void onArchUpdated(int archId) {
        FragmentManager manager = getSupportFragmentManager();
        ArchListFragment listFragment = (ArchListFragment)
                manager.findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
