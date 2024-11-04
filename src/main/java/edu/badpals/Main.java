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
            System.out.println("""
                    
                    ¿Que quieres hacer?
                    1- Ver los paises
                    2- Insertar Un Pais
                    3- Modificar Un Pais
                    4- Eliminiar Un Pais
                    5- Salir""");
            String respuesta = sc.nextLine();
            Pais pais;
            String nombrePais;

            switch (respuesta){
                case "1":
                    System.out.println("Listar Paises:");
                    conexion.getPaises();
                    break;
                case "2":
                    System.out.println("Insertar Pais:");
                    pais = pedirUnPais();
                    conexion.insertarPais(pais);
                    break;
                case "3":
                    System.out.println("Editar Pais:");
                    nombrePais = pedirNombrePais();
                    System.out.println("Dame como quieres que quede el Pais:");
                    pais = pedirUnPais();
                    conexion.modificarPais(nombrePais,pais);
                    break;
                case "4":
                    System.out.println("Eliminar Pais:");
                    nombrePais = pedirNombrePais();
                    conexion.borrarPais(nombrePais);
                    break;
                case "5":
                    System.out.println("¿Seguro Que Quieres Salir? (s/N)");
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
        System.out.println("Dame el nombre del pais");
        return new Scanner(System.in).nextLine();
    }

    private static Pais pedirUnPais() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribeme el nombre del pais");
        String nombrePais = sc.nextLine();
        int numeroHabitantes;
        while (true) {
            System.out.println("Escribeme el numero de habitantes del pais");
            String scRes = sc.nextLine();
            if (scRes.matches("\\d+")){
                numeroHabitantes = Integer.parseInt(scRes);
                break;
            }
            System.out.println("No es un numero valido de habitantes");
        }
        System.out.println("Escribeme el nombre de la capital");
        String nombreCapital = sc.nextLine();
        System.out.println("Escribeme la moneda del pais");
        String nombreMoneda = sc.nextLine();
        return new Pais(nombrePais,numeroHabitantes,nombreCapital,nombreMoneda);
    }


}