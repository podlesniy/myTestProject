package com.example.testapp9;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class Generator extends Fragment {

    public static List<UserModel> generateUser() {
        ArrayList<UserModel> userList = new ArrayList<>();
        userList.add(new UserModel("Жена", "oksana@gmail.com","+380994311234", "Dnepr", R.drawable._0200818_132333));
        userList.add(new UserModel("Мама", "valentina@gmail.com", "+380955343456", "Mirnograd", R.drawable._0200705_164440 ));
        userList.add(new UserModel("Денис", "denchik@gmail.com", "+380501231234", "Mirnograd", R.drawable._0200705_172139_0_));
        return userList;
    }

    public static UserModel contactInfo(String user) {
        if (user.equals(generateUser().get(0).name)) {
            return generateUser().get(0);
        } else if (user.equals(generateUser().get(1).name)) {
            return generateUser().get(1);
        } else if (user.equals(generateUser().get(2).name)) {
            return generateUser().get(2);
        } else {
            return new UserModel("Извините", "но", "пока", "не реализовано", R.drawable.ic_launcher_foreground);
        }
    }
}
