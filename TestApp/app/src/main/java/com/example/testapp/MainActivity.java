package com.example.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button1;
    Button button2;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = findViewById(R.id.error);
        text = findViewById(R.id.text);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        ArrayDeque<String> arr = new ArrayDeque<String>();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().toString().isEmpty()) {
                    arr.add(text.getText().toString());
                    text.setText("");
                    error.setVisibility(View.INVISIBLE);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(arr.pollLast());
                if(arr.size() == 0) {
                    error.setVisibility(View.VISIBLE);
                } else
                    error.setVisibility(View.INVISIBLE);
            }
        });
    }
}