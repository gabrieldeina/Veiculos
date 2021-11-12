package com.example.lojadeveiculos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lojadeveiculos.R;
import com.example.lojadeveiculos.adapter.VeiculoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvVeiculos;
    FloatingActionButton fabAdd;
    VeiculoAdapter veiculoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvVeiculos = findViewById(R.id.rvVeiculos);
        fabAdd = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        veiculoAdapter = new VeiculoAdapter(this);

        rvVeiculos.setLayoutManager(layout);
        rvVeiculos.setAdapter(veiculoAdapter);

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, FormActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        veiculoAdapter.updateDataSet();
    }
}