package com.mobile.mybangga.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.mybangga.Fungsi;
import com.mobile.mybangga.R;

public class AdapterRecyclerViewSpesial  extends RecyclerView.Adapter<AdapterRecyclerViewSpesial.ViewHolder>{

    String[] listspesial;
    Context context;
    Fungsi fungsi;
    public AdapterRecyclerViewSpesial(String[] list_spesial, Context context1) {
        listspesial = list_spesial;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gambarspesial;
        TextView namaspesial;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarspesial = itemView.findViewById(R.id.gambarspesial);
            namaspesial = itemView.findViewById(R.id.namaspesial);
        }

    }
    @NonNull
    @Override
    public AdapterRecyclerViewSpesial.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_spesial,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] element = listspesial[position].split(";");

        fungsi = new Fungsi();

        try {
            holder.gambarspesial.setImageResource(R.drawable.class.getField(element[0]).getInt(null));
            holder.namaspesial.setText(element[1]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getItemCount() {
        return listspesial.length;
    }



}
