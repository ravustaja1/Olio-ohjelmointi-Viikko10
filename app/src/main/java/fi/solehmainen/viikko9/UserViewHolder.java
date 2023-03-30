package fi.solehmainen.viikko9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView userImage, delImage;
    TextView userFName, userLName, email, degree, degrees;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        userImage = itemView.findViewById(R.id.ivUserImage);
        userFName = itemView.findViewById(R.id.txtUserFirstName);
        userLName = itemView.findViewById(R.id.txtUserLastName);
        email = itemView.findViewById(R.id.txtUserEmail);
        degree = itemView.findViewById(R.id.txtUserDegree);
        degrees = itemView.findViewById(R.id.txtSuoritetut);





    }
}
