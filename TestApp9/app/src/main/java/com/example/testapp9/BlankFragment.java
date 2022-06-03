package com.example.testapp9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp9.databinding.FragmentBlankBinding;

import java.util.List;


public class BlankFragment extends Fragment implements OnItemClickListener{

    public static String str;
    private UserAdapter userAdapter;
    private ActivityNavi navi;
    private FragmentBlankBinding binding;
    private final List<UserModel> users = Generator.generateUser();

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false);
        binding.add.setOnClickListener(v -> {
            if(!binding.addName.getText().toString().equals("") && !binding.addEmail.getText().toString().equals("")) {
                userAdapter.addUser(new UserModel(binding.addName.getText().toString(), binding.addEmail.getText().toString(), null, null, R.drawable.ic_launcher_foreground));
                binding.addName.setText("");
                binding.addEmail.setText("");
            }
        });
        binding.list.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        userAdapter = new UserAdapter(binding.getRoot().getContext(), users, this);
        binding.list.setAdapter(userAdapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClick(UserModel userName) {
        str = userName.name;
        navi.showFragment();
    }
}