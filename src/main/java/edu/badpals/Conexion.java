package edu.badpals;

import edu.badpals.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection conexion;

    public Conexion() {
        makeConexion();
    }

    private void makeConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd", "a23victorsn", "renaido");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPaises() {
        try {
            // Execute the query
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Paises");
            List<Pais> paises = new ArrayList<>();
            while (rs.next()) {
                Pais pais = new Pais(rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
                pais.setId(rs.getInt(1));
                paises.add(pais);
                System.out.println(pais);
            }

            // Close the resources
            rs.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertarPais(Pais pais){
        try{
            PreparedStatement s = conexion.prepareStatement("INSERT INTO Paises (nombre_pais, numero_habitantes, nombre_capital, nombre_moneda)  " +
                    " VALUES (?,?,?,?)");
            s.setString(1,pais.getNombre_pais());
            s.setInt(2,pais.getNumero_habitantes());
            s.setString(3,pais.getNombre_capital());
            s.setString(4,pais.getNombre_moneda());
            s.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void cerrarConexion(){
        try{
            this.conexion.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public void borrarPais(int id) {
        try{
            PreparedStatement s = conexion.prepareStatement("DELETE FROM Paises WHERE id = ?");
            s.setInt(1,id);
            s.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
