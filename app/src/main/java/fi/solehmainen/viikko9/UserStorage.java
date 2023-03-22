package fi.solehmainen.viikko9;

import java.util.ArrayList;

public class UserStorage {
    private static UserStorage userStorage = null;
    ArrayList<User> users = new ArrayList<>();


    private UserStorage() {
    }

    public static UserStorage getInstance() {
        if (userStorage == null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers(){

        return users;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user);
        System.out.println(users.size());
    }

    public void removeUser(int id) {
        users.remove(id);
    }

}
