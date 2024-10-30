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
            System.out.println();

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

    public boolean modificarPais(String nombre, Pais pais) {
        String sql = "UPDATE paises SET nombre_pais = ?, numero_habitantes = ?, nombre_capital = ?, nombre_moneda = ? WHERE nombre_pais = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, pais.getNombre_pais());
            statement.setInt(2, pais.getNumero_habitantes());
            statement.setString(3, pais.getNombre_capital());
            statement.setString(4, pais.getNombre_moneda());
            statement.setString(5, nombre);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void borrarPais(String nombre) {
        try{
            PreparedStatement s = conexion.prepareStatement("DELETE FROM Paises WHERE nombre_pais = ?");
            s.setString(1,nombre);
            s.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(){
        try{
            this.conexion.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }
}
