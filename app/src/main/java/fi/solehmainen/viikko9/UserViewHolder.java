package fi.solehmainen.viikko9;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView userImage;
    TextView userFName, userLName, email, degree;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        userImage = itemView.findViewById(R.id.ivUserImage);
        userFName = itemView.findViewById(R.id.txtUserFirstName);
        userLName = itemView.findViewById(R.id.txtUserLastName);
        email = itemView.findViewById(R.id.txtUserEmail);
        degree = itemView.findViewById(R.id.txtUserDegree);

    }
}
