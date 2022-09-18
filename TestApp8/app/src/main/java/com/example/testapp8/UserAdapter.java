package com.example.testapp8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<String> users;
    private List<String> emails;
    private OnItemClickListener listener;
    private List<Integer> imageView;

    public UserAdapter(Context context, List<String> users, List<String> emails, List<Integer> imageViews, OnItemClickListener listener) {
        this.imageView = imageViews;
        this.context = context;
        this.users =  users;
        this.emails = emails;
        this.listener = listener;
    }

    public void addUser(String name, String email) {
        users.add(name);
        emails.add(email);
        imageView.add(R.drawable.ic_launcher_foreground);
        notifyDataSetChanged();
//        notifyItemInserted(users.size() - 1);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new UserViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String userName = users.get(position);
        String userEmail = emails.get(position);
        Integer userImage = imageView.get(position);
        holder.name.setText(userName);
        holder.bind(userName,userEmail,userImage);
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

        public UserViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            root = itemView.findViewById(R.id.root);
            name = itemView.findViewById(R.id.item_name);
            email = itemView.findViewById(R.id.item_email);
            imageView = itemView.findViewById(R.id.image_contact);
        }

        public void bind(String userName,String userEmail, Integer userImage) {
            name.setText(userName);
            email.setText(userEmail);
            imageView.setImageResource(userImage);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(userName);
                }
            });
        }
    }
}
