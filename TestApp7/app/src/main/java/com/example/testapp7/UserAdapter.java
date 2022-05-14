package com.example.testapp7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<String> users;
    private OnItemClickListener listener;

    public UserAdapter(Context context, List<String> users, OnItemClickListener listener) {
        this.context = context;
        this.users = users;
        this.listener = listener;
    }

//    public void addUser(String name) {
//        users.add(name);
////        notifyDataSetChanged();
//        notifyItemInserted(users.size() - 1);
//    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new UserViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String userName = users.get(position);
        //holder.name.setText(userName);
        holder.bind(userName);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        OnItemClickListener listener;
        TextView name;
        View root;

        public UserViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            root = itemView.findViewById(R.id.root);
            name = itemView.findViewById(R.id.item_name);

        }

        public void bind(String userName) {
            name.setText(userName);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(userName);
                }
            });
        }
    }
}
