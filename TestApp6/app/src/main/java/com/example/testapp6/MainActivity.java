package com.example.testapp6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ActivityNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, ChoiceFragment.newInstance()).commit();
    }

    @Override
    public void showDeposit() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DepositFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showCredit() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, CreditFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }
}