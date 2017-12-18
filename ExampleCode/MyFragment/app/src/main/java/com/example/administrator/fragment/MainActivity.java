package com.example.administrator.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageFragment imageFragment;
    ListFragment listFragment;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        imageFragment = (ImageFragment) manager.findFragmentById(R.id.imageFragment);
    }

    public void onChangeFragment(int idx) {
        imageFragment.setImage(idx);
    }
}
