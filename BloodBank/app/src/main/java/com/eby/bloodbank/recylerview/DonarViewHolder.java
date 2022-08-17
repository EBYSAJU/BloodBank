package com.eby.bloodbank.recylerview;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eby.bloodbank.DonarCenter;
import com.eby.bloodbank.R;
import com.eby.bloodbank.SignUp;
import com.eby.bloodbank.db.AppDatabase;
import com.eby.bloodbank.db.dao.DonarsDao;
import com.eby.bloodbank.db.entity.Donars;

import java.util.List;

public class DonarViewHolder extends RecyclerView.ViewHolder {
    TextView name,bloodGroup,gender,id;
    public static final String EXTRA_FIRSTNAME="firstname";

public static int idDonar;


DonarAdapter adapter;



    public DonarViewHolder(@NonNull View itemView,DonarAdapter adapter) {
        super(itemView);

        this.adapter=adapter;
        name=itemView.findViewById(R.id.donar_name);
        bloodGroup=itemView.findViewById(R.id.donar_group);
        gender=itemView.findViewById(R.id.donar_gender);

        final AppDatabase database = AppDatabase.getDatabaseInstance(itemView.getContext());
        final DonarsDao donarsDao = database.donarsDao();
       Log.e("",name.getText().toString()) ;

        itemView.setOnClickListener(v->{
            Log.e("id",SignUp.idSignedIN);

        Log.e("iddonar", String.valueOf(idDonar));
            if(Integer.parseInt(SignUp.idSignedIN)==1){
                Intent intent=new Intent(itemView.getContext(), DonarCenter.class);
                intent.putExtra(EXTRA_FIRSTNAME,name.getText().toString());
                itemView.getContext().startActivity(intent);
            }

        });

    }


public void bind(Donars entity){
name.setText(entity.getFirstName());
bloodGroup.setText(entity.getBloodGroup());
gender.setText(entity.getGender());




}

}
