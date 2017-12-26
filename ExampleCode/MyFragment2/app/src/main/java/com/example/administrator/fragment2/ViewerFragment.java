package com.example.administrator.fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewerFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.dream01);
        return rootView;
    }

    public void setOnImage(int position) {
        Log.e("이미지 클릭 : ", Integer.toString(position));
        switch (position) {
            case 0 :
                imageView.setImageResource(R.drawable.dream01);
                break;
            case 1 :
                imageView.setImageResource(R.drawable.dream02);
                break;
            case 2 :
                imageView.setImageResource(R.drawable.dream03);
                break;
        }
    }

}
