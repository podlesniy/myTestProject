package com.example.testapp9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<UserModel> users;
    private OnItemClickListener listener;

    public UserAdapter(Context context, List<UserModel> users, OnItemClickListener listener) {
        this.context = context;
        this.users =  users;
        this.listener = listener;
    }

    public void addUser(UserModel user) {
        users.add(user);
        notifyDataSetChanged(); // notifyItemInserted(users.size() - 1);

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new UserViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(users.get(position), position); //holder.name.setText(userName);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        OnItemClickListener listener;
        View root;
        TextView name;
        TextView email;
        ImageView imageView;
        //ItemBinding binding;

        public UserViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            //binding = DataBindingUtil.findBinding(itemView);
            root = itemView.findViewById(R.id.root);
            name = itemView.findViewById(R.id.item_name);
            email = itemView.findViewById(R.id.item_email);
            imageView = itemView.findViewById(R.id.image_contact);
        }

        public void bind(UserModel user, int position) {
            name.setText(user.name);
            email.setText(user.email);
            imageView.setImageResource(user.image);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(user.name);
                }
            });
        }
    }
}
