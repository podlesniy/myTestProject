package com.example.testapp9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

public class BlankFragment extends Fragment implements OnItemClickListener{

    public static String str;
    public RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ActivityNavi navi;
    private EditText name;
    private EditText email;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ActivityNavi) {
            navi = (ActivityNavi) context;
        } else {
            throw new IllegalArgumentException(context.getClass().getName() + "не иплементирован ActivityNavi");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        name = root.findViewById(R.id.add_name);
        email = root.findViewById(R.id.add_email);
        Button add_name = root.findViewById(R.id.add);
        add_name.setOnClickListener(v -> {
            if(!name.getText().toString().equals("") && !email.getText().toString().equals("")) {
                userAdapter.addUser(name.getText().toString(), email.getText().toString());
                name.setText("");
                email.setText("");
            }
        });
        recyclerView = root.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        userAdapter = new UserAdapter(root.getContext(), Generator.generateName(), Generator.generateEmail(), Generator.generateIcon(), this);
        recyclerView.setAdapter(userAdapter);
        return root;
    }

    @Override
    public void onItemClick(String userName) {
        str = userName;
        navi.showFragment();
    }
}