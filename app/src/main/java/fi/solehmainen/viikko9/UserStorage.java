package fi.solehmainen.viikko9;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage {
    private static UserStorage userStorage = null;
    //private Context context = getInstance().context.getApplicationContext();
    ArrayList<User> users = new ArrayList<>();

    //Context context;
    private UserStorage() {
    }

    public static UserStorage getInstance() {
        if (userStorage == null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers(){
        // Lajitellaan käyttäjät sukunimen mukaan
        Collections.sort(users, Comparator.comparing(User::getLastName).thenComparing(User::getLastName));

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

    public void loadUsers(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut.");
            e.printStackTrace();
        }
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut.");
            e.printStackTrace();
        }
    }


}
