package com.example.testapp11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp11.databinding.ItemCountryBinding;
import com.example.testapp11.network.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {

    private Context context;
    private List<Country> list = new ArrayList<>();

    public CountryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountryBinding binding = ItemCountryBinding.inflate(LayoutInflater.from(context));
        return new CountryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = list.get(position);
        holder.binding.text.setText(country.name);
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

        public ItemCountryBinding binding;

        public CountryHolder(ItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
