package com.example.testapp3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BlankFragment extends Fragment {

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    private ActivityNavigation navigation;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ActivityNavigation) {
            navigation = (ActivityNavigation) context;
        } else {
            throw new IllegalArgumentException(context.getClass().getName() + "Не имплементировано ActivityNavigation");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_blank1, container, false);
        Button fr1 = root.findViewById(R.id.action);
        Button fr2 = root.findViewById(R.id.action2);
        fr1.findViewById(R.id.action).setOnClickListener(v -> navigation.showFirst());
        fr2.findViewById(R.id.action2).setOnClickListener(v -> navigation.showSecond());
        return root;
    }
}