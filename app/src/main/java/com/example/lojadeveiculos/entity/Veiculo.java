package com.example.lojadeveiculos.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "veiculos")
public class Veiculo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marca;
    private String modelo;
    private String ano;

    public Veiculo(){
    }

    @Ignore
    public Veiculo(int id, String marca, String modelo, String ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
