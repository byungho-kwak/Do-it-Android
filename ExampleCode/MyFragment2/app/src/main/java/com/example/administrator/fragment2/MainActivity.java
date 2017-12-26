package com.example.administrator.fragment2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectedCallback {

    //int[] images = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};

    ListFragment lFragment;
    ViewerFragment vFragment;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        lFragment = (ListFragment) manager.findFragmentById(R.id.list_fragment);
        vFragment = (ViewerFragment) manager.findFragmentById(R.id.view_fragment);
    }

    @Override
    public void onImageSelected(int position) {
        vFragment.setOnImage(position);
    }
}
