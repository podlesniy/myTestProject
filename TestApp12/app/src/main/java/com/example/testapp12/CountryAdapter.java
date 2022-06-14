package com.example.testapp12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp12.databinding.ItemCountryBinding;
import com.example.testapp12.network.model.Country;

import java.util.ArrayList;
import java.util.List;
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {

    private final Context context;
    private final List<Country> list = new ArrayList<>();
    private final OnItemClickListener listener;

    public CountryAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountryBinding binding = ItemCountryBinding.inflate(LayoutInflater.from(context));
        return new CountryHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = list.get(position);
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<Country> countries) {
        list.clear();
        list.addAll(countries);
        notifyDataSetChanged();
    }

    static class CountryHolder extends RecyclerView.ViewHolder {

        ItemCountryBinding binding;
        OnItemClickListener listener;

        public CountryHolder(ItemCountryBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;

        }

        public void bind(Country countries) {
            binding.countryName.setText(countries.name);
            binding.countryCapital.setText(countries.capital);
            binding.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(countries);
                }
            });

        }
    }
}
