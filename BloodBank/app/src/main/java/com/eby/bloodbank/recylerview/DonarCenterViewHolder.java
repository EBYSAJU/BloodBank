package com.eby.bloodbank.recylerview;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eby.bloodbank.R;
import com.eby.bloodbank.db.entity.Donars;

public class DonarCenterViewHolder extends RecyclerView.ViewHolder {
    EditText firstName,gender,bloodGroup;


    public DonarCenterViewHolder(@NonNull View itemView, DonarCenterAdapter donarCenterAdapter) {
        super(itemView);
        firstName=itemView.findViewById(R.id.center_donar_name);
        gender=itemView.findViewById(R.id.center_donar_gender);
        bloodGroup=itemView.findViewById(R.id.center_donar_group);
    }
    public void bind(Donars entity){
        firstName.setText(entity.getFirstName());
        gender.setText(entity.getGender());
        bloodGroup.setText(entity.getBloodGroup());

    }

}
