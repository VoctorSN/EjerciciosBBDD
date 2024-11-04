package edu.badpals.vista;

public class Prints {
    public static void printMenu() {
        System.out.println("""
                    
                    ¿Que quieres hacer?
                    1- Ver los paises
                    2- Insertar Un Pais
                    3- Modificar Un Pais
                    4- Eliminiar Un Pais
                    5- Salir""");
    }

    public static void printSalir() {
        System.out.println("¿Seguro Que Quieres Salir? (s/N)");
    }

    public static void pedirMoneda() {
        System.out.println("Escribeme la moneda del pais");
    }

    public static void pedircapital() {
        System.out.println("Escribeme el nombre de la capital");
    }

    public static void damePais() {
        System.out.println("Vamos a crear un Pais:");
    }

    public static void errorSwitch() {
        System.out.println("Devuelve un numero del 1-5");
    }

    public static void eliminarPais() {
        System.out.println("Eliminar Pais:");
    }

    public static void verPaises() {
        System.out.println("Listar Paises:");
    }

    public static void pedirNombrePais() {
        System.out.println("Dame el nombre del pais");
    }

    public static void pedirHabitantes() {
        System.out.println("Escribeme el numero de habitantes del pais");
    }

   public static void errorHabitantes() {
        System.out.println("No es un numero valido de habitantes");
    }
}
