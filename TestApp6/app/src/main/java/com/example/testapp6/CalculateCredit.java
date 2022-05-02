package com.example.testapp6;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateCredit extends MainActivity {

    float sumCrdF;
    float stavkaCrdF;
    float srokCrdF;
    float strahF;
    float avansF;
    float kommisF;
    float pervVznosF;
    float moncePlatCrdF;
    float pereplF;
    float itogSumPogashF;

    public void getCalculateWithObligatoryCredit(EditText obj, EditText sumCrd, EditText stavkaCrd, EditText srokCrd, EditText strah, EditText avans, EditText kommis, TextView pervVznos, TextView monceDohCrd, TextView perepl, TextView itogSumPogash, TextView errorCredit) {

        obj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((!sumCrd.getText().toString().equals("")) && (!stavkaCrd.getText().toString().equals("")) && (!srokCrd.getText().toString().equals(""))) {
                    if (strah.getText().toString().equals("") && avans.getText().toString().equals("") && kommis.getText().toString().equals("")) {
                        strahF = 0;
                        avansF = 0;
                        kommisF = 0;
                    }
                    getCalculateCredit(sumCrd,stavkaCrd,srokCrd,pervVznos,monceDohCrd,perepl,itogSumPogash);
                    errorCredit.setText("");
                }

                if (obj.getText().toString().equals("")) {
                    pervVznos.setText("");
                    monceDohCrd.setText("");
                    perepl.setText("");
                    itogSumPogash.setText("");
                    errorCredit.setText("Введите значения в обязательные поля");
                }
            }
        });
    }

    public void getCalculateWithSixParametr(EditText obj, EditText obj1, EditText obj2,EditText sumCrd, EditText stavkaCrd, EditText srokCrd, EditText strah, EditText avans, EditText kommis, TextView pervVznos, TextView moncePlatCrd, TextView perepl, TextView itogSumPogash, TextView errorCredit){
        obj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!obj.getText().toString().equals("") && !obj1.getText().toString().equals("") && !obj2.getText().toString().equals("")) {
                    strahF = Float.parseFloat(strah.getText().toString());
                    avansF = Float.parseFloat(avans.getText().toString());
                    kommisF = Float.parseFloat(kommis.getText().toString());
                } else if (!obj.getText().toString().equals("") && obj1.getText().toString().equals("") && obj2.getText().toString().equals("")) {
                    if (obj.getText().toString().equals(strah.getText().toString())) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = 0;
                        kommisF = 0;
                    } else if (obj.getText().toString().equals(avans.getText().toString())) {
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                        kommisF = 0;
                    } else if ((obj.getText().toString().equals(kommis.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        strahF = 0;
                        avansF = 0;
                    }
                } else if (obj.getText().toString().equals("") && !obj1.getText().toString().equals("") && obj2.getText().toString().equals("")) {
                    if (obj1.getText().toString().equals(strah.getText().toString())) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = 0;
                        kommisF = 0;
                    } else if (obj1.getText().toString().equals(avans.getText().toString())) {
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                        kommisF = 0;
                    } else if ((obj1.getText().toString().equals(kommis.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        strahF = 0;
                        avansF = 0;
                    }
                } else if (obj.getText().toString().equals("") && obj1.getText().toString().equals("") && !obj2.getText().toString().equals("")) {
                    if (obj2.getText().toString().equals(strah.getText().toString())) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = 0;
                        kommisF = 0;
                    } else if (obj2.getText().toString().equals(avans.getText().toString())) {
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                        kommisF = 0;
                    } else if ((obj2.getText().toString().equals(kommis.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        strahF = 0;
                        avansF = 0;
                    }
                } else if (!obj.getText().toString().equals("") && !obj1.getText().toString().equals("") && obj2.getText().toString().equals("")) {
                    if ((obj.getText().toString().equals(strah.getText().toString()) && obj1.getText().toString().equals(avans.getText().toString())) || (obj1.getText().toString().equals(strah.getText().toString()) && obj.getText().toString().equals(avans.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        kommisF = 0;
                    } else if ((obj.getText().toString().equals(strah.getText().toString()) && obj1.getText().toString().equals(kommis.getText().toString())) || (obj1.getText().toString().equals(strah.getText().toString()) && obj.getText().toString().equals(kommis.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = 0;
                    } else if ((obj.getText().toString().equals(kommis.getText().toString()) && obj1.getText().toString().equals(avans.getText().toString())) || (obj1.getText().toString().equals(kommis.getText().toString()) && obj.getText().toString().equals(avans.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                    }
                } else if (!obj.getText().toString().equals("") && obj1.getText().toString().equals("") && !obj2.getText().toString().equals("")) {
                    if ((obj.getText().toString().equals(strah.getText().toString()) && obj2.getText().toString().equals(avans.getText().toString())) || (obj2.getText().toString().equals(strah.getText().toString()) && obj.getText().toString().equals(avans.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        kommisF = 0;
                    } else if ((obj.getText().toString().equals(strah.getText().toString()) && obj2.getText().toString().equals(kommis.getText().toString())) || (obj2.getText().toString().equals(strah.getText().toString()) && obj.getText().toString().equals(kommis.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = 0;
                    } else if ((obj.getText().toString().equals(kommis.getText().toString()) && obj2.getText().toString().equals(avans.getText().toString())) || (obj2.getText().toString().equals(kommis.getText().toString()) && obj.getText().toString().equals(avans.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                    }
                } else if (obj.getText().toString().equals("") && !obj1.getText().toString().equals("") && !obj2.getText().toString().equals("")) {
                    if ((obj1.getText().toString().equals(strah.getText().toString()) && obj2.getText().toString().equals(avans.getText().toString())) || (obj2.getText().toString().equals(strah.getText().toString()) && obj1.getText().toString().equals(avans.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        kommisF = 0;
                    } else if ((obj1.getText().toString().equals(strah.getText().toString()) && obj2.getText().toString().equals(kommis.getText().toString())) || (obj2.getText().toString().equals(strah.getText().toString()) && obj1.getText().toString().equals(kommis.getText().toString()))) {
                        strahF = Float.parseFloat(strah.getText().toString());
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = 0;
                    } else if ((obj1.getText().toString().equals(kommis.getText().toString()) && obj2.getText().toString().equals(avans.getText().toString())) || (obj2.getText().toString().equals(kommis.getText().toString()) && obj1.getText().toString().equals(avans.getText().toString()))) {
                        kommisF = Float.parseFloat(kommis.getText().toString());
                        avansF = Float.parseFloat(avans.getText().toString());
                        strahF = 0;
                    }
                } else if (obj.getText().toString().equals("") && obj1.getText().toString().equals("") && obj2.getText().toString().equals("")) {
                    strahF = 0;
                    avansF = 0;
                    kommisF = 0;
                }

                if ((!sumCrd.getText().toString().equals("")) && (!stavkaCrd.getText().toString().equals("")) && (!srokCrd.getText().toString().equals(""))) {
                    getCalculateCredit(sumCrd,stavkaCrd,srokCrd,pervVznos,moncePlatCrd,perepl,itogSumPogash);
                    errorCredit.setText("");
                } else {
                    pervVznos.setText("");
                    moncePlatCrd.setText("");
                    perepl.setText("");
                    itogSumPogash.setText("");
                    errorCredit.setText("Введите значения в обязательные поля");
                }
            }
        });
    }

    public void getCalculateCredit(EditText sumCrd, EditText stavkaCrd, EditText srokCrd, TextView pervVznos, TextView moncePlatCrd, TextView perepl, TextView itogSumPogash) {
        sumCrdF = Float.parseFloat(sumCrd.getText().toString());
        stavkaCrdF = Float.parseFloat(stavkaCrd.getText().toString());
        srokCrdF = Float.parseFloat(srokCrd.getText().toString());

        float stavkaYear = (((sumCrdF - pervVznosF) * stavkaCrdF) / 100) / 12;
        pervVznosF = (sumCrdF * avansF) / 100;
        moncePlatCrdF = ((sumCrdF - pervVznosF) / srokCrdF) + stavkaYear + (((sumCrdF - pervVznosF) * strahF) / 100) + (((sumCrdF - pervVznosF) * kommisF) / 100);
        pereplF = ((stavkaYear * srokCrdF) + (((sumCrdF - pervVznosF) * strahF) / 100) + (((sumCrdF - pervVznosF) * kommisF) / 100) * srokCrdF);
        itogSumPogashF = sumCrdF - pervVznosF + pereplF;

        String pervVznosS = String.format("%.2f", pervVznosF);
        String moncePlatCrdS = String.format("%.2f", moncePlatCrdF);
        String pereplS = String.format("%.2f", pereplF);
        String itogSumPogashS = String.format("%.2f", itogSumPogashF);

        pervVznos.setText(pervVznosS);
        moncePlatCrd.setText(moncePlatCrdS);
        perepl.setText(pereplS);
        itogSumPogash.setText(itogSumPogashS);
    }
}
