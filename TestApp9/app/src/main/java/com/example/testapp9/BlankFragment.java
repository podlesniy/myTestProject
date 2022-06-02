package com.example.testapp9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
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

import com.example.testapp9.databinding.FragmentBlankBinding;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

public class BlankFragment extends Fragment implements OnItemClickListener{

    public static String str;
    private UserAdapter userAdapter;
    private ActivityNavi navi;
    private FragmentBlankBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        binding.add.setOnClickListener(v -> {
            if(!binding.addName.getText().toString().equals("") && !binding.addEmail.getText().toString().equals("")) {
                userAdapter.addUser(binding.addName.getText().toString(), binding.addEmail.getText().toString());
                binding.addName.setText("");
                binding.addEmail.setText("");
            }
        });
        binding.list.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        userAdapter = new UserAdapter(binding.getRoot().getContext(), Generator.generateName(), Generator.generateEmail(), Generator.generateIcon(), this);
        binding.list.setAdapter(userAdapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClick(String userName) {
        str = userName;
        navi.showFragment();
    }
}