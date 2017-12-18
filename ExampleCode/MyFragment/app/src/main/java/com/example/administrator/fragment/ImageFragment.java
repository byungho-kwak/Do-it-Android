package com.example.administrator.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageFragment extends Fragment {

    ImageView imageView;
    MainActivity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup Fragment = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);
        imageView = (ImageView) Fragment.findViewById(R.id.imgFragment);
        return Fragment;
    }

    public void setImage(int idx) {
        if(idx == 1) {
            imageView.setImageResource(R.drawable.image1);
        } else if(idx == 2) {
            Toast.makeText(activity.getApplicationContext(), "idx==2", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.image2);
        } else {
            Toast.makeText(activity.getApplicationContext(), "idx==3", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.image3);
        }
    }

}
