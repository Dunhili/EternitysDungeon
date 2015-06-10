package com.dunhili.eternitysdungeon.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dunhili.eternitysdungeon.R;
import com.dunhili.eternitysdungeon.map.MapEditor;

/**
 * Created by Dunhili on 6/7/2015.
 */
public class MapEditorFragment extends Fragment {
    private MapEditor mGenerator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGenerator = new MapEditor();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_generator_fragment, parent, false);
        return view;
    }
}
