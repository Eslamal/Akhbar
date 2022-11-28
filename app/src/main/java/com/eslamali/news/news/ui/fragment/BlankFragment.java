package com.eslamali.news.news.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eslamali.news.R;


public class BlankFragment extends BaseFragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        intialFragment();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}