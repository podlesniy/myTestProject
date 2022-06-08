package com.example.testapp11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testapp11.databinding.ActivityMainBinding;
import com.example.testapp11.network.ApiService;
import com.example.testapp11.network.model.Country;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    private Disposable disposable;
    private ActivityMainBinding binding;
    private CountryAdapter adapter;
    static Country countries;
    List<Country> country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new CountryAdapter(this, this);
        binding.recyclerList.setAdapter(adapter);
        binding.recyclerList.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //or set - app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" in xml

        disposable = ApiService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showInfo, this::showError);
    }

    public void showInfo(List<Country> countries) {
//        Toast.makeText(MainActivity.this, countries.get(0).name, Toast.LENGTH_SHORT).show();
            adapter.update(countries);

    }

    public void showError(Throwable t) {
        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onItemClick(Country country) {
        countries = country;
        startActivity(new Intent("com.example.mainactivity2"));
    }
}