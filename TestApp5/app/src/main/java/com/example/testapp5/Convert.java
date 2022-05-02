package com.example.testapp5;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Convert extends MainActivity {

    public void getConvert(EditText obj, TextView obj1, int i) {
        obj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!obj.getText().toString().equals("")) {
                    int sum = Integer.parseInt(obj.getText().toString());
                    String sum1 = "";
                    if (i == 2) {
                        sum1 = Integer.toBinaryString(sum);
                    } else if (i == 8) {
                        sum1 = Integer.toOctalString(sum);
                    } else {
                        sum1 = Integer.toHexString(sum);
                    }
                    obj1.setText(sum1);
                } else {
                    obj1.setText(obj1.getHint());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
