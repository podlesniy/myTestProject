package com.example.testapp3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment2 extends Fragment {

    public static BlankFragment2 newInstance(){
       return new BlankFragment2();
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }
}