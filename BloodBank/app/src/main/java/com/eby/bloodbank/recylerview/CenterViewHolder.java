package com.eby.bloodbank.recylerview;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eby.bloodbank.R;
import com.eby.bloodbank.db.entity.DonarCenters;

public class CenterViewHolder extends RecyclerView.ViewHolder {
    EditText centerName, address, phonenumber, centercode;

    public CenterViewHolder(@NonNull View itemView, CenterAdapter centerAdapter) {
        super(itemView);
        centerName = itemView.findViewById(R.id.forrecyclerview_centername);
        address = itemView.findViewById(R.id.forrecyclerview_address);
        phonenumber = itemView.findViewById(R.id.forrecyclerview_phonenumber);
        centercode = itemView.findViewById(R.id.forrecyclerview_center_code);

    }

    public void bind(DonarCenters donarCenters) {
        centerName.setText(donarCenters.getCenterName());
        address.setText(donarCenters.getAddress());
        phonenumber.setText(donarCenters.getContactNumber());
        centercode.setText(String.valueOf(donarCenters.getCenterCode()));

    }
}
