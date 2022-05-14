package com.example.testapp7;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<String> generate() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Компьютер");
        list.add("Смартфон");
        list.add("Телевизор");
        return list;
    }

    public static String characters(String name) {
        String charact = "";
        switch (name) {
            case "Компьютер":
                charact = "Материнская память: Gigabyte g41-Combo\n" +
                        "Процессор: Intel Core i7\n" +
                        "Оперативная память: 4Gb\n" +
                        "Жесткий диск: 240Gb";
                break;
            case "Смартфон":
                charact = "Фирма: Samsung\n" +
                        "Процессор: Snapdragon 855\n" +
                        "Оперативная память: 12Gb\n" +
                        "Встроемая память: 1Tb\n" +
                        "Камера: 12Mpx";
                break;
            case "Телевизор":
                charact = "Фирма: LG\n" +
                        "Экран: 55 дюймов\n" +
                        "Система: WebOS\n";
                break;
        }
        return charact;
    }
}
