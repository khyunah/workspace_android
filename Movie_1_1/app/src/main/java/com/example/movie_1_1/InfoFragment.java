package com.example.movie_1_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends Fragment {

    private static InfoFragment infoFragment;

    private InfoFragment() {

    }

    public static InfoFragment getInstance() {
        if (infoFragment == null) {
            infoFragment = new InfoFragment();
        }
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}