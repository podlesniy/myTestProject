package com.example.testapp4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentOne extends Fragment {

    TextView view_name;
    TextView view_old;
    TextView view_month;
    TextView view_day;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root  = inflater.inflate(R.layout.fragment_one, container, false);

        view_name = (TextView) root.findViewById(R.id.view_name);
        view_day = (TextView) root.findViewById(R.id.view_day);
        view_month = (TextView) root.findViewById(R.id.view_month);
        view_old = (TextView) root.findViewById(R.id.view_old);

        String dateFormat = FragmentZero.year.getText() + "-" + FragmentZero.month.getText() + "-" + FragmentZero.day.getText();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateTime = date.getTime();
        long timeMillis = System.currentTimeMillis();
        long days = (timeMillis - dateTime) / 1000 / 60 / 60 / 24;

        view_name.setText(String.format("%s%s", view_name.getText().toString(), FragmentZero.name.getText()));
        view_old.setText(String.format("%s%s", view_old.getText().toString(), days/365));
        view_day.setText(String.format("%s%s", view_day.getText().toString(), days));
        view_month.setText(String.format("%s%.0f", view_month.getText().toString(), Math.floor(days/30.4)));

        return root;
    }
}