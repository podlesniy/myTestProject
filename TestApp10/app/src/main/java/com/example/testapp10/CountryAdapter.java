package com.example.testapp10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import java.util.Locale;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private final Context context;
    private final List<RequestModel.ExchangeRate> countries;
    private final OnItemClickListener listener;

    public CountryAdapter(Context context, List<RequestModel.ExchangeRate> countries, OnItemClickListener listener) {
        this.context = context;
        this.countries = countries;
        this.listener = listener;
    }


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CountryViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {

        OnItemClickListener listener;
        TextView country;
        View root;

        public CountryViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            country = itemView.findViewById(R.id.item_name);
            root = itemView.findViewById(R.id.root);
        }

        public void bind(RequestModel.ExchangeRate countries) {
            String formattedRate = String.format(Locale.US, "Rate of %s is %.2f", countries.getCurrency(), countries.getSaleRateNB());
            country.setText(formattedRate);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(countries);
                }
            });

        }
    }
}
