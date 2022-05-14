package com.example.testapp7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class BlankFragment extends Fragment implements OnItemClickListener{

    private RecyclerView recyclerView;
//    private Button add;
    private UserAdapter userAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
//        add = root.findViewById(R.id.add);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userAdapter.addUser("New user");
//            }
//        });
        recyclerView = root.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        userAdapter = new UserAdapter(root.getContext(), Generator.generate(), this);
        recyclerView.setAdapter(userAdapter);
        return root;
    }

    @Override
    public void onItemClick(String userName) {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle(userName)
                .setMessage(Generator.characters(userName))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}