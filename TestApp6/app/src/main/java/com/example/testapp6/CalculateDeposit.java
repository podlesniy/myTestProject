package com.example.testapp6;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateDeposit extends MainActivity {

    float nalogF;
    float popolnF;
    float sumVklF;
    float sumVklVgod;
    float sumVklPlusMonce;
    float stavkaF;
    float dohod;
    float dohodForMonce;
    float dohodItog;
    float sumPop;
    int srokF;

    public void getCalculateWithObligatory(EditText obj, EditText sumVkl, EditText stavka, EditText srok, CheckBox kapit, EditText popoln, EditText nalog, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum, TextView error, TextView allDohNMonce) {

        obj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((!sumVkl.getText().toString().equals("")) && (!stavka.getText().toString().equals("")) && (!srok.getText().toString().equals(""))) {
                    if (nalog.getText().toString().equals("") && popoln.getText().toString().equals("")) {
                        nalogF = 0;
                        popolnF = 0;
                    }
                    getCalculate(sumVkl,stavka,srok,kapit,monceDoh,allDoh,allPopoln,itogSum, allDohNMonce);
                    error.setText("");
                }
                if (obj.getText().toString().equals("")) {
                    getError(allDohNMonce,monceDoh,allDoh,allPopoln,itogSum,error);
                }
            }
        });
    }

    public void getCalculateWithCheckBox (CheckBox obj, EditText sumVkl, EditText stavka, EditText srok, CheckBox kapit, EditText popoln, EditText nalog, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum, TextView error, TextView allDohNMonce) {
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if ((!sumVkl.getText().toString().equals("")) && (!stavka.getText().toString().equals("")) && (!srok.getText().toString().equals(""))) {
                        getCalculate(sumVkl, stavka, srok, kapit, monceDoh, allDoh, allPopoln, itogSum, allDohNMonce);
                        error.setText("");
                    }

                    if (sumVkl.getText().toString().equals("") || stavka.getText().toString().equals("") || srok.getText().toString().equals("")) {
                        getError(allDohNMonce,monceDoh,allDoh,allPopoln,itogSum,error);
                    }
            }
        });
    }

    public void getCalculateWithFiveParametr(EditText obj, EditText obj1, EditText sumVkl, EditText stavka, EditText srok, CheckBox kapit, EditText popoln, EditText nalog, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum, TextView error, TextView allDohNMonce){
        obj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    if (!obj.getText().toString().equals("") && !obj1.getText().toString().equals("")) {
                        nalogF = Float.parseFloat(nalog.getText().toString());
                        popolnF = Float.parseFloat(popoln.getText().toString());
                    } else if (!obj.getText().toString().equals("") && obj1.getText().toString().equals("")) {
                        if (obj.getText().toString().equals(popoln.getText().toString())) {
                            popolnF = Float.parseFloat(popoln.getText().toString());
                            nalogF = 0;
                        } else if (obj.getText().toString().equals(nalog.getText().toString())) {
                            nalogF = Float.parseFloat(nalog.getText().toString());
                            popolnF = 0;
                        }
                    } else if (obj.getText().toString().equals("") && !obj1.getText().toString().equals("")) {
                        if (obj1.getText().toString().equals(popoln.getText().toString())) {
                            popolnF = Float.parseFloat(popoln.getText().toString());
                            nalogF = 0;
                        } else if (obj1.getText().toString().equals(nalog.getText().toString())) {
                            nalogF = Float.parseFloat(nalog.getText().toString());
                            popolnF = 0;
                        }
                    } else if (obj.getText().toString().equals("") && obj1.getText().toString().equals("")) {
                        nalogF = 0;
                        popolnF = 0;
                    }

                    if ((!sumVkl.getText().toString().equals("")) && (!stavka.getText().toString().equals("")) && (!srok.getText().toString().equals(""))) {
                        getCalculate(sumVkl, stavka, srok, kapit, monceDoh, allDoh, allPopoln, itogSum, allDohNMonce);
                        error.setText("");
                    }

                    if (sumVkl.getText().toString().equals("") || srok.getText().toString().equals("") || stavka.getText().toString().equals("")) {
                        getError(allDohNMonce,monceDoh,allDoh,allPopoln,itogSum,error);
                    }
            }
        });
    }

    public void getCalculate(EditText sumVkl, EditText stavka, EditText srok, CheckBox kapit, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum,TextView allDohNMonce) {
        sumVklF = Float.parseFloat(sumVkl.getText().toString());
        stavkaF = Float.parseFloat(stavka.getText().toString());
        srokF = Integer.parseInt(srok.getText().toString());
        sumVklVgod = sumVklF;
        float prForMonce = stavkaF / 12;
        sumPop = ((float) srokF) * popolnF;
        int ostatok = (int) srokF % 12;

        if (srokF >= 13) {
            if (kapit.isChecked()) {

                int kolYear = ((int) srokF - (int) ostatok) / 12;
                for (int i = 0; i < kolYear; i++) {
                    sumVklVgod += ((sumVklF * stavkaF) / 100) + (12 * popolnF);
                }
                sumVklPlusMonce = sumVklVgod + ((sumVklVgod * (ostatok * prForMonce)) / 100) + (ostatok * popolnF);
                dohod = sumVklPlusMonce - sumVklF - sumPop;
                dohodForMonce = dohod / srokF;
                dohodItog = dohod - (dohod * nalogF / 100) + sumVklF + sumPop;

                getViewDisplayDeposit(srokF,dohodForMonce,dohod,sumPop,dohodItog,allDohNMonce,monceDoh,allDoh,allPopoln,itogSum);
            } else {
                getCalculateWithoutKapit(ostatok,srokF,popolnF,dohod,dohodItog,nalogF,sumPop,dohodForMonce,prForMonce,allDohNMonce,monceDoh,allDoh,allPopoln,itogSum);
            }
        } else {
            getCalculateWithoutKapit(ostatok,srokF,popolnF,dohod,dohodItog,nalogF,sumPop,dohodForMonce,prForMonce,allDohNMonce,monceDoh,allDoh,allPopoln,itogSum);
        }
    }

    public void getError(TextView allDohNMonce, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum, TextView error){
        String allDohNMonceS = "Общий доход через N мес";
        allDohNMonce.setText(allDohNMonceS);
        monceDoh.setText("");
        allDoh.setText("");
        allPopoln.setText("");
        itogSum.setText("");
        error.setText("Введите значения в обязательные поля");
    }

    public void getCalculateWithoutKapit(int ostatok, int srokF, float popolnF, float dohod, float dohodItog, float nalogF, float sumPop, float dohodForMonce, float prForMonce,TextView allDohNMonce, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum) {
        sumVklVgod += (((sumVklF * prForMonce) / 100) * (srokF - ostatok)) + ((sumVklF * (ostatok * prForMonce)) / 100) + sumPop;
        dohod = sumVklVgod - sumVklF - sumPop;
        dohodForMonce = dohod / srokF;
        dohodItog = dohod - ((dohod * nalogF) / 100) + sumVklF + sumPop;
        getViewDisplayDeposit(srokF,dohodForMonce,dohod,sumPop,dohodItog,allDohNMonce,monceDoh,allDoh,allPopoln,itogSum);
    }

    public void getViewDisplayDeposit(int srokF, float dohodForM, float doh, float sumPop, float dohodIt, TextView allDohNMonce, TextView monceDoh, TextView allDoh, TextView allPopoln, TextView itogSum) {
        String allDohNMonceS = ("Общий доход через " + srokF + " мес");
        String dohodForMonceS = String.format("%.2f",dohodForM);
        String dohodS = String.format("%.2f",doh);
        String sumPopS = String.format("%.2f",sumPop);
        String dohodItogS = String.format("%.2f",dohodIt);

        allDohNMonce.setText(allDohNMonceS);
        monceDoh.setText(dohodForMonceS);
        allDoh.setText(dohodS);
        allPopoln.setText(sumPopS);
        itogSum.setText(dohodItogS);
    }
}