package com.example.testapp8;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class Generator extends Fragment {

    public static List<String> generateName() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Жена");
        nameList.add("Мама");
        nameList.add("Денис");
        return nameList;
    }

    public static List<String> generateEmail() {
        ArrayList<String> emailList = new ArrayList<>();
        emailList.add("oksana@gmail.com");
        emailList.add("valentina@gmail.com");
        emailList.add("denchik@gmail.com");
        return emailList;
    }

    public static String[] contactInfo(String name) {
        String[] contInf;
        if (name.equals(generateName().get(0))) {
            contInf = new String[]{generateName().get(0), "+380994311234", generateEmail().get(0), "Dnepr"};
        } else if (name.equals(generateName().get(1))) {
            contInf = new String[]{generateName().get(1), "+380955343456", generateEmail().get(1), "Mirnograd"};
        } else if (name.equals(generateName().get(2))) {
            contInf = new String[]{generateName().get(2), "+380501231234", generateEmail().get(2), "Mirnograd"};
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
        if (name.equals(generateName().get(0))) {
            return generateIcon().get(0);
        } else if (name.equals(generateName().get(1))) {
            return generateIcon().get(1);
        } else if (name.equals(generateName().get(2))) {
            return generateIcon().get(2);
        } else {
            return R.drawable.ic_launcher_foreground;
        }
    }
}
