package com.example.testapp4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentZero extends Fragment {

    public static EditText name;
    public static EditText day;
    public static EditText month;
    public static EditText year;


    public static FragmentZero newInstance() {
        return new FragmentZero();
    }

    private ActivityNavi navi;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityNavi) {
            navi = (ActivityNavi) context;
        } else {
            throw new IllegalArgumentException(context.getClass().getName() + "не иплементирован ActivityNavi");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_zero, container, false);
        name = (EditText) root.findViewById(R.id.name);
        day = (EditText) root.findViewById(R.id.day);
        month = (EditText) root.findViewById(R.id.month);
        year = (EditText) root.findViewById(R.id.year);

        root.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navi.showFragment();
            }
        });

        return root;
    }
}