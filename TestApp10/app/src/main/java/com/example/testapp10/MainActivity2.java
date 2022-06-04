package com.example.testapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    TextView baseCurrency;
    TextView currency;
    TextView saleRateNB;
    TextView purchaseRateNB;
    TextView saleRate;
    TextView purchaseRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        baseCurrency = findViewById(R.id.baseCurrency);
        currency = findViewById(R.id.currency);
        saleRateNB = findViewById(R.id.saleRateNB);
        purchaseRateNB = findViewById(R.id.purchaseRateNB);
        saleRate = findViewById(R.id.saleRate);
        purchaseRate = findViewById(R.id.purchaseRate);

        viewFullInfo(MainActivity.exchangeRate);
    }

    public void viewFullInfo(RequestModel.ExchangeRate country) {
        baseCurrency.setText(country.getBaseCurrency());
        currency.setText(country.getCurrency());
        saleRateNB.setText(String.format(Locale.US, "%s", country.getSaleRateNB()));
        purchaseRateNB.setText(String.format(Locale.US, "%s", country.getPurchaseRateNB()));
        saleRate.setText(String.format(Locale.US, "%s", country.getSaleRate()));
        purchaseRate.setText(String.format(Locale.US, "%s", country.getPurchaseRate()));
    }
}