package com.example.testapp11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp11.databinding.ActivityMain2Binding;
import com.example.testapp11.network.ApiService;
import com.example.testapp11.network.model.Country;

import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    public CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        disposable.add(ApiService.getCountryByName(MainActivity.countries.name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(countries -> !countries.isEmpty())
                .subscribe(countries -> {
                    Country country = countries.get(0);
                    setView(binding.name, binding.textView1, country.name);
                    setView(binding.capital, binding.textView2, country.capital);
                    setView(binding.region, binding.textView3, country.region);
                    setView(binding.population, binding.textView4, String.valueOf(country.population));
                    setView(binding.area, binding.textView5, String.valueOf(country.area));
                }, throwable -> {
                    Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
                }));
//        setView(binding.name, binding.textView1, MainActivity.countries.name);
//        setView(binding.capital, binding.textView2, MainActivity.countries.capital);
//        setView(binding.region, binding.textView3, MainActivity.countries.region);
//        setView(binding.population, binding.textView4, String.valueOf(MainActivity.countries.population));
//        setView(binding.area, binding.textView5, String.valueOf(MainActivity.countries.area));
    }

    public void setView(TextView view, TextView view1, String countries) {
        if (String.format("%s", countries).equals("null")) {
            view.setVisibility(View.GONE);
            view1.setVisibility(View.GONE);
        } else {
            view.setText(String.format(Locale.US, "%s", countries));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.clear();
    }
}
