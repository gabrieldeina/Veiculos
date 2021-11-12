package com.example.lojadeveiculos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lojadeveiculos.R;
import com.example.lojadeveiculos.database.VeiculosDB;
import com.example.lojadeveiculos.database.dao.VeiculoDAO;
import com.example.lojadeveiculos.entity.Veiculo;

public class FormActivity extends AppCompatActivity {

    EditText etMarca;
    EditText etModelo;
    EditText etAno;
    Button btnSalvar;

    VeiculoDAO veiculoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        etAno = findViewById(R.id.etAno);
        btnSalvar = findViewById(R.id.btnSalvar);

        veiculoDAO = VeiculosDB.getInstance(this).getVeiculoDAO();

        Intent intent = getIntent();

        Veiculo editarVeiculo;

        if (intent.hasExtra("veiculo")) {
            editarVeiculo = (Veiculo) intent.getSerializableExtra("veiculo");
            etMarca.setText(editarVeiculo.getMarca());
            etModelo.setText(editarVeiculo.getModelo());
            etAno.setText(editarVeiculo.getAno());
        } else {
            editarVeiculo = null;
        }

        btnSalvar.setOnClickListener(v -> {
            if(etModelo.getText().toString().isEmpty() ||
            etMarca.getText().toString().isEmpty() ||
            etAno.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                Veiculo veiculo = new Veiculo(
                        0,
                        etMarca.getText().toString(),
                        etModelo.getText().toString(),
                        etAno.getText().toString()
                );

                if(editarVeiculo == null) {
                    veiculoDAO.salvar(veiculo);
                } else {
                    veiculo.setId(editarVeiculo.getId());
                    veiculoDAO.editarVeiculo(veiculo);
                }

                Toast.makeText(this, "Veículo cadastrado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}