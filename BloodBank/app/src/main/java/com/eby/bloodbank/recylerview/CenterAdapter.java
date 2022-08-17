package com.eby.bloodbank.recylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eby.bloodbank.R;
import com.eby.bloodbank.db.entity.DonarCenters;
import com.eby.bloodbank.db.entity.Donars;

import java.util.ArrayList;
import java.util.List;

public class CenterAdapter extends RecyclerView.Adapter<CenterViewHolder> {
    private List<DonarCenters> data = new ArrayList<>();
    public void add(List<DonarCenters> donarcenters) {
        data.addAll(donarcenters);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new CenterViewHolder(inflatedView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CenterViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.center_list_recycler;
    }
}
