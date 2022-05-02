package com.example.testapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityNavigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
            .replace(R.id.container, BlankFragment.newInstance())
            .commit();
    }

    @Override
    public void showFirst() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, BlankFragment1.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showSecond() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, BlankFragment2.newInstance())
                .addToBackStack(null)
                .commit();
    }
}