package com.dunhili.eternitysdungeon.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.dunhili.eternitysdungeon.R;

/**
 * Created by Dunhili on 6/7/2015.
 */
public class MapEditorActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_generator_activity);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.map_generator_container);
        if (fragment == null) {
            fragment = new MapEditorFragment();
            manager.beginTransaction().add(R.id.map_generator_container, fragment).commit();
        }
    }
}
