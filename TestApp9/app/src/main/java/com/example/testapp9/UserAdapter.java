package com.example.testapp9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.testapp9.databinding.ItemBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final Context context;
    private final List<UserModel> users;
    private final OnItemClickListener listener;

    public UserAdapter(Context context, List<UserModel> users, OnItemClickListener listener) {
        this.context = context;
        this.users =  users;
        this.listener = listener;
    }

    public void addUser(UserModel user) {
        users.add(user);
        notifyItemInserted(users.size() - 1); // notifyDataSetChanged();

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding b = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item, parent, false);
        return new UserViewHolder(b, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(users.get(position)); //holder.name.setText(userName);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        OnItemClickListener listener;
        ItemBinding binding;

        public UserViewHolder(ItemBinding b, OnItemClickListener listener) {
            super(b.getRoot());
            this.binding = b;
            this.listener = listener;
        }

        public void bind(UserModel user) {
            binding.setUser(user);
            binding.imageContact.setImageResource(user.image);
            binding.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(user);
                }
            });
        }
    }
}
