package com.example.testapp12;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp12.network.model.Country;

import java.util.List;

public class Filtered {

    public static void filteredByName(List<Country> countries, EditText editText, Button button, List<Country> countryFiltered, CountryAdapter adapter) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryFiltered.clear();
                for (Country country : countries) {
                    if (((!String.format("%s", country.name).equals("null")) && (country.name.toLowerCase().contains(editText.getText().toString())))
                            || ((!String.format("%s", country.name).equals("null")) && (country.name.toUpperCase().contains(editText.getText().toString())))
                            || (!String.format("%s", country.name).equals("null")) && (country.name.contains(editText.getText().toString())))
                    {
                        countryFiltered.add(country);
                    }
                }
                adapter.update(countryFiltered);
                if (editText.getText().toString().equals("")) {
                    adapter.update(countries);
                }
            }
        });
    }

    public static void filteredByCapital(List<Country> countries, EditText editText, Button button, List<Country> countryFiltered, CountryAdapter adapter) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryFiltered.clear();
                for (Country country : countries) {
                    if (((!String.format("%s", country.capital).equals("null")) && (country.capital.toLowerCase().contains(editText.getText().toString())))
                            || ((!String.format("%s", country.capital).equals("null")) && (country.capital.toUpperCase().contains(editText.getText().toString())))
                            || (!String.format("%s", country.capital).equals("null")) && (country.capital.contains(editText.getText().toString())))
                    {
                        countryFiltered.add(country);
                    }
                }
                adapter.update(countryFiltered);
                if (editText.getText().toString().equals("")) {
                    adapter.update(countries);
                }
            }
        });
    }

    public static void filteredByPopulation(List<Country> countries, EditText editText, Button button, List<Country> countryFiltered, CountryAdapter adapter) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryFiltered.clear();
                double pop = 0;
                if (!editText.getText().toString().isEmpty()) {
                    pop = Double.parseDouble(editText.getText().toString());
                }
                for (Country country : countries) {
                    if ((country.population >= pop - ((pop * 15.0) / 100))
                            && (country.population <= pop + ((pop * 15.0) / 100)))
                    {
                        countryFiltered.add(country);
                    }
                }
                adapter.update(countryFiltered);
                if (editText.getText().toString().equals("")) {
                    adapter.update(countries);
                }
            }
        });
    }

    public static void filteredByArea(List<Country> countries, EditText editText, Button button, List<Country> countryFiltered, CountryAdapter adapter) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryFiltered.clear();
                double area = 0;
                if (!editText.getText().toString().isEmpty()) {
                    area = Double.parseDouble(editText.getText().toString());
                }

                for (Country country : countries) {
                    if ((!String.format("%s", country.area).equals("null")) && (country.area >= area - ((area * 15.0) / 100))
                            && (country.area <= area + ((area * 15.0) / 100))) {
                        countryFiltered.add(country);
                    }
                }
                adapter.update(countryFiltered);
                if (editText.getText().toString().equals("")) {
                    adapter.update(countries);
                }
            }
        });
    }

}
