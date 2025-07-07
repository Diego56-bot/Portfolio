package PD8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;
import java.util.List;


public class EstructurasYAlgoritmos {
    String nombre;
    ArrayList<String> sucursales = new ArrayList<>();

    public EstructurasYAlgoritmos() {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarSucursal(String nombre) {
        if (!sucursales.contains(nombre)) {
            sucursales.add(nombre);
        }

    }

    public void quitarSucursal(String nombre) {
        if (sucursales.contains(nombre)) {
            sucursales.remove(nombre);
        }

    }

    public void listarSucursales() {
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println("SUCURSAL: " + sucursales.get(i));
        }
    }

    public void cantidadDeSucursales() {
        System.out.println("La cantidad de sucursales son: " + sucursales.size());
    }

    public void isEmpty() {
        if (sucursales.isEmpty()) {
            System.out.println("La cantidad de sucursales es vacia");
        } else {
            System.out.println("La cantidad de sucursales no es vacia");
        }
    }
    public void ciudadSiguiente(String nombre) {
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).equals(nombre)) {
                System.out.println("SUCURSAL SIGUIENTE: " + sucursales.get(i+1));
            }
        }
    }
    public void imprimirLista() {
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.print( sucursales.get(i) + ";_");
        }
    }

    public void cargarArchivo(String archivo) {
        try (BufferedReader  br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                agregarSucursal(linea.trim());
            }
            imprimirLista();

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

