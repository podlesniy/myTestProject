package com.example.testapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class TView extends Fragment {

    public static TextView textView1;
    public static TextView textView2;
    public static TextView textView3;

    public static TView getInstance() {
        return new TView();
    }

    Convert convert = new Convert();
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root1 = inflater.inflate(R.layout.text_view, container, false);
        textView1 = (TextView) root1.findViewById(R.id.text_view1);
        textView2 = (TextView) root1.findViewById(R.id.text_view2);
        textView3 = (TextView) root1.findViewById(R.id.text_view3);

        convert.getConvert(EdText.editOne, TView.textView1, 2);
        convert.getConvert(EdText.editSecond, TView.textView2, 8);
        convert.getConvert(EdText.editThird, TView.textView3, 16);

        return root1;
    }
}
