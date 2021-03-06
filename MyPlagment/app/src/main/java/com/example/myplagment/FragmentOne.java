package com.example.myplagment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {

    private static final String TAG ="Fragment1";

    public FragmentOne() {

    }

    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate 호출");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView 호출");
        // 메모리에 xml 파일을 올리는 것
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    // 뷰가 완전 올라갓을때
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated 호출");
    }

    // 문서에 보면 더이상 사용하지 않는다고 나와있음
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach 호출");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored 호출");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 호출");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 호출");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 호출");
    }
}