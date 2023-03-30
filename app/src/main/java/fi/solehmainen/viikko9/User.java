package fi.solehmainen.viikko9;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;


    private ArrayList<String> degrees = new ArrayList<>();



    private int image;

    public User(String firstName, String lastName, String email, String degreeProgram, int image, ArrayList<String> degrees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.degrees = degrees;

        if(image == 0) {
            this.image = R.drawable.baseline_bluetooth_drive_24;
        }

        if(image == 1) {
            this.image = R.drawable.ic_android_black_24dp;
        }


    }



    public int getImage() {
        return image;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public ArrayList<String> getDegrees() {
        return degrees;
    }
}
