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
import org.json.JSONArray;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    String[] listdompet;
    Context context;
    Fungsi fungsi;
    public AdapterRecyclerView(String[] list_dompet, Context context1) {
        listdompet = list_dompet;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logodompet;
        TextView jenisdompet;
        TextView isidompet;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            logodompet = itemView.findViewById(R.id.logodompet);
            jenisdompet = itemView.findViewById(R.id.jenisdompet);
            isidompet = itemView.findViewById(R.id.isidompet);
        }
    }
    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_dompet,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] element = listdompet[position].split(";");

        fungsi = new Fungsi();

        try {
            holder.logodompet.setImageResource(R.drawable.class.getField(element[0]).getInt(null));
            holder.jenisdompet.setText(element[1]);
            holder.isidompet.setText(fungsi.formatRupiah(Double.parseDouble(element[2])));
            if (element[2].equals("0"))
                holder.isidompet.setVisibility(View.INVISIBLE);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        return listdompet.length;
    }


}
