package edu.badpals.controlador;

import edu.badpals.modelo.ConexionPaises;
import edu.badpals.vista.Inputs;
import edu.badpals.vista.Prints;

public class Controller {
    ConexionPaises conexion = new ConexionPaises();
    Inputs inputs = new Inputs();

    public void comenzar() {
        boolean salir = false;
        do {
            String respuesta = inputs.displayMenu();

            switch (respuesta){
                case "1":
                    verPaises();
                    break;
                case "2":
                    insertarPais();
                    break;
                case "3":
                    editarPais();
                    break;
                case "4":
                    eliminarPais();
                    break;
                case "5":
                    salir = inputs.preguntarSalida();
                    break;
                default:
                    Prints.errorSwitch();
                    break;
            }


        }while (!salir);
    }

    private void eliminarPais(){
        conexion.borrarPais(inputs.eliminarPais());
    }

    private void editarPais(){
        conexion.modificarPais(inputs.pedirNombrePais(),inputs.pedirUnPais());
    }

    private void insertarPais() {
        conexion.insertarPais(inputs.insertarPais());
    }

    private void verPaises() {
        Prints.verPaises();
        conexion.getPaises();
    }



}
