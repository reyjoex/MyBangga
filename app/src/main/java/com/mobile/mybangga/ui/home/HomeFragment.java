package com.mobile.mybangga.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.mybangga.DataSementara;
import com.mobile.mybangga.Fungsi;
import com.mobile.mybangga.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    RecyclerView recyclerViewSpesial;
    RecyclerView.Adapter recyclerViewAdapterSpesial;
    RecyclerView.LayoutManager recylerViewLayoutManagerSpesial;
    Fungsi fungsi;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        DataSementara dataSementara = new DataSementara();
        fungsi = new Fungsi();

        binding = FragmentHomeBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        try {
            JSONObject saldo_rekening = new JSONObject(dataSementara.saldo_rekening);
            JSONArray res_saldo = saldo_rekening.getJSONArray("saldo");
            final TextView nominal0 = binding.nominalrekening0;
            JSONObject jo = res_saldo.getJSONObject(0);
            nominal0.setText(fungsi.formatNonRupiah(Double.valueOf(jo.getString("nominal"))));
//            nominal0.setText(jo.getString("nominal"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        try {
            JSONObject jsonObject = new JSONObject(dataSementara.list_dompet);
            JSONArray result = jsonObject.getJSONArray("menu");
            String[] arrdompet = new String[result.length()];
            for(int i=0;i<result.length();i++){
                JSONObject jo = result.getJSONObject(i);
                arrdompet[i] = jo.getString("logo")+";"+jo.getString("nama")+";"+jo.getString("nominal");
            }
            recyclerView = binding.recylceViewDompet;
            recylerViewLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(recylerViewLayoutManager);

            recyclerViewAdapter = new AdapterRecyclerView(arrdompet, recyclerView.getContext());
            recyclerView.setAdapter(recyclerViewAdapter);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        try {
            JSONObject jsonObject = new JSONObject(dataSementara.list_spesial);
            JSONArray rspesial = jsonObject.getJSONArray("spesial");
            String[] arrspesial = new String[rspesial.length()];
            for(int i=0;i<rspesial.length();i++){
                JSONObject jo = rspesial.getJSONObject(i);
                arrspesial[i] = jo.getString("gambar")+";"+jo.getString("nama");
            }

            recyclerViewSpesial = binding.recylceViewSpesial;
            recylerViewLayoutManagerSpesial = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL,false);
            recyclerViewSpesial.setLayoutManager(recylerViewLayoutManagerSpesial);
            recyclerViewAdapterSpesial = new AdapterRecyclerViewSpesial(arrspesial, recyclerViewSpesial.getContext());
            recyclerViewSpesial.setAdapter(recyclerViewAdapterSpesial);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}