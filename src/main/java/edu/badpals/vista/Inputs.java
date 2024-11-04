package edu.badpals.vista;

import edu.badpals.modelo.Pais;

import java.util.Objects;
import java.util.Scanner;

public class Inputs {
    Scanner sc = new Scanner(System.in);
    Pais pais;
    String nombrePais;

    public String displayMenu(){
        Prints.printMenu();
        return sc.nextLine();
    }

    public boolean preguntarSalida() {
        Prints.printSalir();
        return Objects.equals(sc.nextLine(), "s");
    }


    public String pedirNombrePais() {
        Prints.pedirNombrePais();
        return sc.nextLine();
    }

    public Pais insertarPais() {
        return pedirUnPais();
    }

    public String eliminarPais() {
        Prints.eliminarPais();
        return pedirNombrePais();
    }


    public Pais pedirUnPais() {
        Prints.damePais();
        String nombrePais = pedirNombrePais();
        int numeroHabitantes;
        while (true) {
            Prints.pedirHabitantes();
            String scRes = sc.nextLine();
            if (scRes.matches("\\d+")){
                numeroHabitantes = Integer.parseInt(scRes);
                break;
            }
            Prints.errorHabitantes();
        }
        Prints.pedircapital();
        String nombreCapital = sc.nextLine();
        Prints.pedirMoneda();
        String nombreMoneda = sc.nextLine();
        return new Pais(nombrePais,numeroHabitantes,nombreCapital,nombreMoneda);
    }

}
