package com.example.lojadeveiculos.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lojadeveiculos.database.dao.VeiculoDAO;
import com.example.lojadeveiculos.entity.Veiculo;

@Database(entities = {Veiculo.class}, version = 1, exportSchema = false)
public abstract class VeiculosDB extends RoomDatabase {

    private static final String DB_NAME = "veiculos.db";

    private static VeiculosDB instance;

    public abstract VeiculoDAO getVeiculoDAO();

    public static VeiculosDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, VeiculosDB.class, DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }
}
