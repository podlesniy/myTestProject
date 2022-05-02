package com.example.testapp6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ChoiceFragment extends Fragment {

    public static ChoiceFragment newInstance() {
        return new ChoiceFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Finance calculator");
        View root = inflater.inflate(R.layout.fragment_choice, container, false);
        Button button1 = root.findViewById(R.id.button1);
        Button button2 = root.findViewById(R.id.button2);
        button1.findViewById(R.id.button1).setOnClickListener(v -> navigation.showDeposit());
        button2.findViewById(R.id.button2).setOnClickListener(v -> navigation.showCredit());
        return root;

    }
}