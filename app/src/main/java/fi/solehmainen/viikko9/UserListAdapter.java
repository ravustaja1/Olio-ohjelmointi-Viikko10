package fi.solehmainen.viikko9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<User> users2 = UserStorage.getInstance().getUsers();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //ArrayList<String> strings = new ArrayList<>();
        //ArrayList<User> users = new ArrayList<>();

        holder.userFName.setText(users.get(position).getFirstName());
        holder.userLName.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
        holder.degree.setText(users.get(position).getDegreeProgram());
        holder.userImage.setImageResource(users.get(position).getImage());
        //holder.degrees.setText(users.get(position).getDegrees());

        StringBuilder sb = new StringBuilder();
        //sb.append("Testi");
        System.out.println(sb.toString());
        int i=0;
        for(i=0;i<users.get(position).getDegrees().size();i++) {
            sb.append(users.get(position).getDegrees().get(i) + "\n");

        }
        holder.degrees.setText(sb.toString());
        //System.out.println(sb.toString());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
