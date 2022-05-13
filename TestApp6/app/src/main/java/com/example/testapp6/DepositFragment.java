package com.example.testapp6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class DepositFragment extends Fragment {

    EditText sumVkl;
    EditText stavka;
    EditText srok;
    CheckBox kapit;
    EditText popoln;
    EditText nalog;
    TextView monceDoh;
    TextView allDoh;
    TextView allPopoln;
    TextView itogSum;
    TextView error;
    TextView allDohNMonce;

    CalculateDeposit calculateDeposit = new CalculateDeposit();
    
    public static DepositFragment newInstance() {
        return new DepositFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);
        getActivity().setTitle("Deposit calculator");

        sumVkl = root.findViewById(R.id.sumVkl);
        stavka = root.findViewById(R.id.stavka);
        srok = root.findViewById(R.id.srok);
        kapit = root.findViewById(R.id.checkBox);
        popoln = root.findViewById(R.id.popoln);
        nalog = root.findViewById(R.id.nalog);
        monceDoh = root.findViewById(R.id.monceDoh);
        allDoh = root.findViewById(R.id.allDoh);
        allPopoln = root.findViewById(R.id.allPopoln);
        itogSum = root.findViewById(R.id.itogSum);
        error = root.findViewById(R.id.error);
        allDohNMonce = root.findViewById(R.id.allDohNMonce);

        calculateDeposit.getCalculateWithObligatory(sumVkl,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);
        calculateDeposit.getCalculateWithObligatory(stavka,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);
        calculateDeposit.getCalculateWithObligatory(srok,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);
        calculateDeposit.getCalculateWithCheckBox(kapit,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);
        calculateDeposit.getCalculateWithFiveParametr(popoln,nalog,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);
        calculateDeposit.getCalculateWithFiveParametr(nalog,popoln,sumVkl,stavka,srok,kapit,popoln,nalog,monceDoh,allDoh,allPopoln,itogSum,error,allDohNMonce);

        return root;
    }
}