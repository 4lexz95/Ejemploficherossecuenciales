package ejemplo01;

import java.io.File;
import java.util.Scanner;

public class listaDirectorios {
    public static  void main(String[] args) {

        //listarFicherosDirActual();
        listarficherossolic();
    }
    private static void listarficherossolic(){
        Scanner sc = new Scanner(System.in);
        String dir =".";
        String resp = "";
        System.out.println("Dime la ruta del directorio");
        resp = sc.nextLine();
        File file = new File (resp);
        if (!file.exists()){
            System.out.printf("No existe el directorio");
        }else {
            String[] archivos = file.list();
            System.out.printf("Ficheros en el directorio actual : %d", archivos.length);
            for (String fichero:archivos
            ) {
                File temp = new File(file, fichero);
                System.out.printf("Nombre: %s - FILE: %b - Dir: %b%n", temp.getName(),temp.isFile(),temp.isDirectory());
            }

        }
;

    }

    private static void listarFicherosDirActual() {
        String dirActual = ".";
        File file = new File(dirActual);
        // Mostrar la lista de nombres que tiene el array
        String[] archivos = file.list();
        System.out.printf("Ficheros en el directorio actual : %d", archivos.length);
        System.out.printf("Ficheros en el directorio actual %s : %d %n", file.getName(), archivos.length);
        for (String fichero:archivos
             ) {
            File temp = new File(file, fichero);
            System.out.printf("Nombre: %s - FILE: %b - Dir: %b%n", temp.getName(),temp.isFile(),temp.isDirectory());
        }
    }
}
