package fi.solehmainen.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage s = UserStorage.getInstance();

        context = MainActivity.this;

        s.loadUsers(this);
        //s.addUser(new User("Teppo", "Tohveli", "teppo@tohveli.fi", "Tietotekniikka"));
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToListUsers(View view) {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }

    public void loadUsers(View view) {
        UserStorage.getInstance().loadUsers(context);
    }

    public  void saveUsers(View view) {
        UserStorage.getInstance().saveUsers(context);
    }

}