package com.example.testapp8;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Generator extends Fragment {

    private static ArrayList<String> nameList;
    private static ArrayList<String> emailList;

    public static List<String> generateName() {
        nameList = new ArrayList<>();
        nameList.add("Жена");
        nameList.add("Мама");
        nameList.add("Денис");
        return nameList;
    }

    public static List<String> generateEmail() {
        emailList = new ArrayList<>();
        emailList.add("oksana@gmail.com");
        emailList.add("valentina@gmail.com");
        emailList.add("denchik@gmail.com");
        return emailList;
    }

    public static String[] contactInfo(String name) {
        String[] contInf;
        if (name.equals(nameList.get(0))) {
            contInf = new String[]{nameList.get(0), "+380993110015", emailList.get(0), "Dnepr"};
        } else if (name.equals(nameList.get(1))) {
            contInf = new String[]{nameList.get(1), "+380958072245", emailList.get(1), "Dimitrov"};
        } else if (name.equals(nameList.get(2))) {
            contInf = new String[]{nameList.get(2), "+380501231234", emailList.get(2), "Dimitrov"};
        } else {
            contInf = new String[]{"Извините","но","пока","не реализовано"};
        }
        return contInf;
    }

    public static List<Integer> generateIcon() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable._0200818_132333);
        list.add(R.drawable._0200705_164440);
        list.add(R.drawable._0200705_172139_0_);
        return list;
    }

    public static Integer generateImage(String name) {
        Integer list = 0;
        if (name.equals(nameList.get(0))) {
            list = R.drawable._0200818_132333;
        } else if (name.equals(nameList.get(1))) {
            list = R.drawable._0200705_164440;
        } else if (name.equals(nameList.get(2))) {
            list = R.drawable._0200705_172139_0_;
        }
        return list;
    }
}
