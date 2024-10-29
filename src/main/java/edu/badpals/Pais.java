package edu.badpals;

import java.math.BigInteger;

public class Pais {
    int id = 0;
    String nombre_pais;
    int numero_habitantes;
    String nombre_capital;
    String nombre_moneda;

    public Pais(String nombre_pais, int numero_habitantes, String nombre_capital, String nombre_moneda) {
        this.nombre_pais = nombre_pais;
        this.numero_habitantes = numero_habitantes;
        this.nombre_capital = nombre_capital;
        this.nombre_moneda = nombre_moneda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public int getNumero_habitantes() {
        return numero_habitantes;
    }

    public void setNumero_habitantes(int numero_habitantes) {
        this.numero_habitantes = numero_habitantes;
    }

    public String getNombre_capital() {
        return nombre_capital;
    }

    public void setNombre_capital(String nombre_capital) {
        this.nombre_capital = nombre_capital;
    }

    public String getNombre_moneda() {
        return nombre_moneda;
    }

    public void setNombre_moneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre_pais='" + nombre_pais + '\'' +
                ", numero_habitantes=" + numero_habitantes +
                ", nombre_capital='" + nombre_capital + '\'' +
                ", nombre_moneda='" + nombre_moneda;
    }
}
