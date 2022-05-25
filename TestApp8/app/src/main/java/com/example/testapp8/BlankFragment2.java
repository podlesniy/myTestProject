package com.example.testapp8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BlankFragment2 extends Fragment {

    TextView name;
    TextView email;
    TextView phone;
    TextView adr;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_blank2, container, false);
        imageView = root.findViewById(R.id.imageView);
        name = root.findViewById(R.id.name);
        email = root.findViewById(R.id.email);
        phone = root.findViewById(R.id.phone);
        adr = root.findViewById(R.id.adr);

        viewContact(Generator.contactInfo(BlankFragment.str));

        return root;
    }

    public void viewContact(String[] contact){
        name.setText(contact[0]);
        phone.setText(contact[1]);
        email.setText(contact[2]);
        adr.setText(contact[3]);
        imageView.setImageResource(Generator.generateImage(BlankFragment.str));
    }
}