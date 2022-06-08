package com.example.testapp11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.example.testapp11.databinding.ActivityMain2Binding;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    TextView name;
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        name = findViewById(R.id.name);
        binding.name.setText(MainActivity.countries.name);
        binding.capital.setText(MainActivity.countries.capital);
        binding.region.setText(MainActivity.countries.region);
        binding.population.setText(String.format(Locale.US, "%s", MainActivity.countries.population));
        binding.area.setText(String.format(Locale.US, "%s", MainActivity.countries.area));
    }
}