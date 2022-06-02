package com.example.testapp9;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp9.databinding.FragmentBlank2Binding;
import com.example.testapp9.databinding.FragmentBlankBinding;


public class BlankFragment2 extends Fragment {

    private FragmentBlank2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank2, container, false);

        viewContact(Generator.contactInfo(BlankFragment.str));

        return binding.getRoot();
    }

    public void viewContact(String[] contact){
        binding.name.setText(contact[0]);
        binding.phone.setText(contact[1]);
        binding.email.setText(contact[2]);
        binding.adr.setText(contact[3]);
        binding.imageView.setImageResource(Generator.generateImage(BlankFragment.str));
    }
}