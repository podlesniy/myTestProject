package com.example.testapp2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText phone;
    EditText pass1;
    EditText pass2;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.personName);
        email = findViewById(R.id.emailAddress);
        phone = findViewById(R.id.phone);
        pass1 = findViewById(R.id.password1);
        pass2 = findViewById(R.id.password2);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        phone.getText().toString().isEmpty() ||
                        pass1.getText().toString().isEmpty() ||
                        pass2.getText().toString().isEmpty()) {
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Ошибка")
                            .setMessage("Все поля должны быть заполнены")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else if (!pass1.getText().toString().equals(pass2.getText().toString())) {
                    AlertDialog dialog1 = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Ошибка")
                            .setMessage("Пароли не совпадают")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog1, int which) {
                                    dialog1.dismiss();
                                }
                            }).create();
                    dialog1.show();
                } else if (!(phone.getText().toString().startsWith("+380") && (phone.getText().length() == 13))) {
                    AlertDialog dialog3 = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Ошибка")
                            .setMessage("Номер телефона введён неверно. Нужно вводить в формате '+380(**)1234567'")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog3, int which) {
                                    dialog3.dismiss();
                                }
                            }).create();
                    dialog3.show();
                } else if (!isEmail(email.getText().toString())) {
                    AlertDialog dialog2 = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Ошибка.")
                            .setMessage("Email введён неверно")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog2, int which) {
                                    dialog2.dismiss();
                                }
                            }).create();
                    dialog2.show();
                } else {
                    AlertDialog dialog2 = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Поздравляем.")
                            .setMessage("Вы вошли в систему")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog2, int which) {
                                    dialog2.dismiss();
                                }
                            }).create();
                    dialog2.show();
                }
            }
            public boolean isEmail(String mail) {
                return mail.matches("^[-0-9a-zA-Z.+_]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}");
            }
        });
    }
}