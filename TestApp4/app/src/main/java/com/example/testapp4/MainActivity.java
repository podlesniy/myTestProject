package com.example.testapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityNavi{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentZero fragment = new FragmentZero();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FragmentZero.newInstance())
                .commit();
    }

    public void showFragment() {
        FragmentOne fOne = new FragmentOne();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fOne)
                .addToBackStack(null)
                .commit();
    }
}