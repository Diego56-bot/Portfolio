package PD10;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("entrada.txt"));
            String linea1 = lector.readLine();
            String linea2 = lector.readLine();
            lector.close();

            String[] palabras1 = linea1.split(" ");
            String[] palabras2 = linea2.split(" ");

            String[] comunes = ContadorPalabras.palabrasComunes(palabras1, palabras2);

            System.out.println("Las palabras comunes son:");
            for (String palabra : comunes) {
                System.out.println(palabra);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
