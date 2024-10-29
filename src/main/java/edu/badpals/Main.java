package edu.badpals;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getPaises();

        Pais pais = new Pais("pais",15,"capital","moneda");
        if (conexion.insertarPais(pais)){
            System.out.println("\n");
        }

        conexion.getPaises();

        conexion.borrarPais(13);
        conexion.cerrarConexion();
    }
}