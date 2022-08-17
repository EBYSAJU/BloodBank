package com.eby.bloodbank.recylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eby.bloodbank.R;
import com.eby.bloodbank.db.entity.Donars;

import java.util.ArrayList;
import java.util.List;

public class DonarAdapter extends RecyclerView.Adapter<DonarViewHolder> {
    private List<Donars> data = new ArrayList<>();
    public void add(List<Donars> users) {
        data.addAll(users);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DonarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new DonarViewHolder(inflatedView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DonarViewHolder holder, int position) {
        holder.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.donarslist;
    }
}
