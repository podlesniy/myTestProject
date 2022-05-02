package com.example.testapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class EdText extends Fragment {

    public static EditText editOne;
    public static EditText editSecond;
    public static EditText editThird;

    public static EdText getInstance() {
        return new EdText();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ed_text, container, false);

        editOne = (EditText) root.findViewById(R.id.edit_text1);
        editSecond = (EditText) root.findViewById(R.id.edit_text2);
        editThird = (EditText) root.findViewById(R.id.edit_text3);

        return root;
    }
}
