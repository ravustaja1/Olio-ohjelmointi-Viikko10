package fi.solehmainen.viikko9;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;



    private int image;

    public User(String firstName, String lastName, String email, String degreeProgram, int image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;

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


}
