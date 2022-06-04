package com.example.testapp10;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    EditText editText;
    Button button;
    static RequestModel.ExchangeRate exchangeRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.enter_date);
        button = findViewById(R.id.ok);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        changeDate(date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!editText.getText().toString().equals(""))) {
                    changeDate(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
    }

    @Override
    public void onItemClick(RequestModel.ExchangeRate countries) {
        exchangeRate = countries;
        Intent intent = new Intent("com.example.mainactivity2");
        startActivity(intent);
    }

    public void changeDate(String date) {
        ApiService.getData(date)
                .enqueue(new Callback<RequestModel>() {
                    @Override
                    public void onResponse(Call<RequestModel> call, Response<RequestModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            recyclerView = findViewById(R.id.list);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                            ArrayList<RequestModel.ExchangeRate> list = new ArrayList<>();
                            for(int i = 1; i < 15; i++) {
                                list.add(response.body().getExchangeRate().get(i));
                            }
                            countryAdapter = new CountryAdapter(MainActivity.this, list, MainActivity.this);
                            recyclerView.setAdapter(countryAdapter);
                        } else {
                            Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
