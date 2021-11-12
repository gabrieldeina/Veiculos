package com.example.lojadeveiculos.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lojadeveiculos.entity.Veiculo;

import java.util.List;

@Dao
public interface VeiculoDAO {

    @Insert
    void salvar(Veiculo veiculo);

    @Update
    void editarVeiculo(Veiculo veiculo);

    @Delete
    void deletarVeiculo(Veiculo veiculo);

    @Query("SELECT * FROM veiculos")
    List<Veiculo> getVeiculos();
}
