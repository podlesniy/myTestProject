package com.example.testapp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container, EdText.getInstance())
                .commit();

        fm.beginTransaction()
                .replace(R.id.container1, TView.getInstance())
                .commit();
    }
}