package com.example.islandbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SelectorFragment selectorFragment = new SelectorFragment();
    MapFragment mapFragment= new MapFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMapFragment();
        loadSelectorFragment();
    }

    private void loadSelectorFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.selector);
        if(fragment==null){
            fm.beginTransaction().add(R.id.selector,selectorFragment).commit();
        }else{
            fm.beginTransaction().replace(R.id.selector,selectorFragment).commit();

        }
    }

    private void loadMapFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.map);
        if(fragment==null){
            fm.beginTransaction().add(R.id.map,mapFragment).commit();
        }else{
            fm.beginTransaction().replace(R.id.map,mapFragment).commit();

        }
    }
}