package fi.solehmainen.viikko9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {
    private EditText firstName;

    private EditText lastName;

    private EditText email;

    private Spinner spinner;

    private View degreeType;

    private ImageView previewImg;
    private CheckBox cbKandi, cbDi, cbTt, cbUima;

    private int image;
    ArrayList<User> users = new ArrayList<>();

    private String degree;

    private ImageView ivSelectionImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        degreeType = findViewById(R.id.rgDegreeType);
        spinner = findViewById(R.id.spinner);
        //ivSelectionImg = findViewById(R.id.ivSelectionImg);
        previewImg = findViewById(R.id.ivPreviewImg);
        //ivSelectionImg = findViewById(R.id.ivPreviewImg);
        cbKandi = findViewById(R.id.cbKandi);
        cbTt = findViewById(R.id.cbTt);
        cbDi = findViewById(R.id.cbDi);
        cbUima = findViewById(R.id.cbUima);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.images, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinner.getSelectedItemPosition() == 0){
                    //image = R.drawable.baseline_bluetooth_drive_24;
                    previewImg.setImageResource(image = R.drawable.baseline_bluetooth_drive_24);
                }

                if (spinner.getSelectedItemPosition() == 1){
                    previewImg.setImageResource(image = R.drawable.ic_android_black_24dp);
                    //image = R.drawable.ic_android_black_24dp;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                image = R.drawable.baseline_bluetooth_drive_24;
            }

        });

        //private ImageView ivSelectionImg;

    }



    public void addUser(View view) {
        RadioGroup rgDegreeType = findViewById(R.id.rgDegreeType);
        ArrayList<String> degrees = new ArrayList<>();

        switch(rgDegreeType.getCheckedRadioButtonId()) {
            case R.id.rbTietotekniikka:
                //UserStorage.getInstance().addUser(new User(R.id.editFirstName, R.id.editFirstName, R.id.editEmail, "Tietotekniikka"));
                degree = "Tietotekniika";
                break;
            case R.id.rbTuotantotalous:
                //UserStorage.getInstance().addUser(new User(R.id.editFirstName, R.id.editFirstName, R.id.editEmail, "Tietotekniikka"));
                degree = "Tuotantotalous";
                break;
            case R.id.rbLaskennallinen:
                //UserStorage.getInstance().addUser(new User(R.id.editFirstName, R.id.editFirstName, R.id.editEmail, "Tietotekniikka"));
                degree = "Laskennallinen tekniikka";
                break;
            case R.id.rbSahkotekniikka:
                //UserStorage.getInstance().addUser(new User(R.id.editFirstName, R.id.editFirstName, R.id.editEmail, "Tietotekniikka"));
                degree = "Sähkötekniikka";
                break;
        }
        int choice = spinner.getSelectedItemPosition();
        //if (choice == 1)
        if (cbKandi.isChecked()) {
            degrees.add("Kandidaatin tutkinto");
        }
        if (cbDi.isChecked()) {
            degrees.add("Diplomi-insinöörin tutkinto");
        }
        if (cbTt.isChecked()) {
            degrees.add("Tekniikan tohtorin tutkinto");
        }
        if (cbUima.isChecked()) {
            degrees.add("Uimamaisteri");
        }

        //System.out.println(degrees);

        User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), degree, choice, degrees);
        UserStorage.getInstance().addUser(user);


        // Tallennetaan users muuttujaan käyttäjät, jonka jälkeen suoritetaan tallennus tiedostoon.
        users = UserStorage.getInstance().getUsers();
        UserStorage.getInstance().saveUsers(this);

    }


}