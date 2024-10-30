package edu.badpals;

import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        Conexion conexion = new Conexion();
        
        /*conexion.getPaises();

        Pais pais = new Pais("pais",15,"capital","moneda");
        conexion.insertarPais(pais);

        conexion.getPaises();

        pais.setNombre_pais("pais2");

        conexion.modificarPais("pais",pais);

        conexion.getPaises();

        conexion.borrarPais("pais2");

        conexion.getPaises();

        conexion.cerrarConexion(); */
        do {
            System.out.println("¿Que quieres hacer?\n" +
                    "1- Ver los paises\n" +
                    "2- Insertar Un Pais\n" +
                    "3-Modificar Un Pais\n" +
                    "4-Eliminiar Un Pais\n" +
                    "5-Salir");
            String respuesta = sc.nextLine();
            Pais pais;
            String nombrePais;

            switch (respuesta){
                case "1":
                    conexion.getPaises();
                    break;
                case "2":
                    pais = pedirUnPais();
                    conexion.insertarPais(pais);
                    break;
                case "3":
                    pais = pedirUnPais();
                    nombrePais = pedirNombrePais();
                    conexion.modificarPais(nombrePais,pais);
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("¿Seguro Que Quieres Salir?");
                    if (Objects.equals(sc.nextLine(), "s")){
                        salir = true;
                    }
                    break;
                default:
                    System.out.println("Devuelve un numero del 1-5");
                    break;
            }

            
        }while (!salir);
    }

    private static String pedirNombrePais() {
    }

    private static Pais pedirUnPais() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribeme el nombre del pais");
        String nombrePais = sc.nextLine();
        System.out.println("Escribeme el numero de habitantes del pais");
        int numeroHabitantes = Integer.parseInt(sc.nextLine());
        System.out.println("Escribeme el nombre de la capital");
        String nombreCapital = sc.nextLine();
        System.out.println("Escribeme la moneda del pais");
        String nombreMoneda = sc.nextLine();
        return new Pais(nombrePais,numeroHabitantes,nombreCapital,nombreMoneda);
    }


}