package com.example.lojadeveiculos.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lojadeveiculos.R;

public class VeiculoViewHolder extends RecyclerView.ViewHolder {

    TextView tvMarca;
    TextView tvModelo;
    TextView tvAno;
    Button btnEditar;
    Button btnDeletar;

    public VeiculoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvModelo = itemView.findViewById(R.id.tvModelo);
        tvMarca = itemView.findViewById(R.id.tvMarca);
        tvAno = itemView.findViewById(R.id.tvAno);
        btnEditar = itemView.findViewById(R.id.btnEditar);
        btnDeletar = itemView.findViewById(R.id.btnDeletar);
    }
}
