package com.example.lojadeveiculos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lojadeveiculos.R;
import com.example.lojadeveiculos.database.VeiculosDB;
import com.example.lojadeveiculos.database.dao.VeiculoDAO;
import com.example.lojadeveiculos.entity.Veiculo;
import com.example.lojadeveiculos.ui.FormActivity;

import java.util.List;

public class VeiculoAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Veiculo> listaVeiculos;
    private VeiculoDAO veiculoDAO;

    public VeiculoAdapter(Context context) {
        this.context = context;
        veiculoDAO = VeiculosDB.getInstance(context).getVeiculoDAO();
        listaVeiculos = veiculoDAO.getVeiculos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.veiculo_layout, parent, false);
        VeiculoViewHolder veiculoViewHolder = new VeiculoViewHolder(itemView);
        return veiculoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Veiculo veiculo = listaVeiculos.get(position);

        VeiculoViewHolder veiculoViewHolder = (VeiculoViewHolder) holder;

        veiculoViewHolder.tvModelo.setText(veiculo.getModelo());
        veiculoViewHolder.tvMarca.setText(veiculo.getMarca());
        veiculoViewHolder.tvAno.setText(veiculo.getAno());

        veiculoViewHolder.btnEditar.setOnClickListener(v -> {
            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("veiculo", veiculo);
            context.startActivity(editarIntent);
        });

        veiculoViewHolder.btnDeletar.setOnClickListener(v -> {
                veiculoDAO.deletarVeiculo(veiculo);
                updateDataSet();
        });
    }

    @Override
    public int getItemCount() {
        return listaVeiculos.size();
    }

    public void updateDataSet() {
        listaVeiculos.clear();
        listaVeiculos = veiculoDAO.getVeiculos();
        notifyDataSetChanged();
    }
}
