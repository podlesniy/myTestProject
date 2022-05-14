package com.example.testapp6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CreditFragment extends Fragment {

    EditText sumCrd;
    EditText stavkaCrd;
    EditText srokCrd;
    EditText strah;
    EditText avans;
    EditText kommis;
    TextView pervVznos;
    TextView monceDohCrd;
    TextView perepl;
    TextView itogSumPogash;
    TextView errorCrd;
    FrameLayout frame;

    CalculateCredit calculateCredit = new CalculateCredit();
    public static CreditFragment newInstance() {
        return new CreditFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_credit, container, false);
        getActivity().setTitle("Credit calculator");

        sumCrd = root.findViewById(R.id.sumCrd);
        stavkaCrd = root.findViewById(R.id.stavkaCrd);
        srokCrd = root.findViewById(R.id.srokCrd);
        strah = root.findViewById(R.id.strah);
        avans = root.findViewById(R.id.avans);
        kommis = root.findViewById(R.id.kommis);
        pervVznos = root.findViewById(R.id.pervVznos);
        monceDohCrd = root.findViewById(R.id.monceDohCrd);
        perepl = root.findViewById(R.id.perepl);
        itogSumPogash = root.findViewById(R.id.itogSumPogash);
        errorCrd = root.findViewById(R.id.errorCrd);

        calculateCredit.getCalculateWithObligatoryCredit(sumCrd,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithObligatoryCredit(stavkaCrd,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithObligatoryCredit(srokCrd,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithSixParametr(strah,avans,kommis,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithSixParametr(strah,kommis,avans,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithSixParametr(avans,strah,kommis,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithSixParametr(kommis,avans,strah,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        calculateCredit.getCalculateWithSixParametr(avans,kommis,strah,sumCrd,stavkaCrd,srokCrd,strah,avans,kommis,pervVznos,monceDohCrd,perepl,itogSumPogash,errorCrd);
        return root;
    }
}