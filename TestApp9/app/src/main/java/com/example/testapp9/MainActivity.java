package com.example.testapp9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityNavi {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment fFirst = new BlankFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fFirst)
                .commit();
    }

    public void showFragment() {
        BlankFragment2 fSecond = new BlankFragment2();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fSecond)
                .addToBackStack(null)
                .commit();
    }
}