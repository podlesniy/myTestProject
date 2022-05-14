package com.example.testapp8;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Generator extends Fragment {

    public static List<String> generateName() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Оксана");
        list.add("Мама");
        list.add("Денис");
        return list;
    }

    public static List<String> generateEmail() {
        ArrayList<String> list = new ArrayList<>();
        list.add("oksana@gmail.com");
        list.add("valentina@gmail.com");
        list.add("denchik@gmail.com");
        return list;
    }

    public static String[] contactInfo(String name) {
        String[] contInf;
        switch (name) {
            case "Оксана":
                contInf = new String[]{"Оксана", "0993110015", "oksana@gmail.com", "Dnepr"};
                break;
            case "Мама":
                contInf = new String[]{"Мама", "0958072245", "valentina@gmail.com", "Dimitrov"};
                break;
            case "Денис":
                contInf = new String[]{"Денис", "0501231234", "denchik@gmail.com", "Dimitrov"};
                break;
            default:
                contInf = new String[]{"Извините","но","пока","не реализовано"};
        }
        return contInf;
    }
}
