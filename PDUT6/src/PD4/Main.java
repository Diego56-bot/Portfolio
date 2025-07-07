package PD4;

import PD1.ManejadorArchivosGenerico;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        String[] mugre = ManejadorArchivosGenerico.leerArchivo("PDUT6/src/PD4/libro.txt").toArray(new String[0]);
        HashMap<String, Integer> esUnMapa = obtenerPalabras(Arrays.toString(mugre));
        List<HashMap.Entry<String, Integer>> listita = ordenarPorFrecuencia(esUnMapa);

        System.out.println("10 PALABRAS MAS FRECUENTES");
        for (int i = 0; i < 10; i++) {
            System.out.println(listita.get(i));
        }
    }

    static HashMap<String, Integer> obtenerPalabras(String lineas) {
        HashMap<String, Integer> mapa = new HashMap<>();
        String[] palabras = lineas.toLowerCase().split("[\\s\\p{Punct}&&[^'-]]+");

        for (String s : palabras) {
            if (mapa.containsKey(s)){
                mapa.put(s, mapa.get(s)+1);
            } else {
                mapa.put(s, 1);
            }
        }

        return mapa;
    }

    static List<HashMap.Entry<String, Integer>> ordenarPorFrecuencia(HashMap<String, Integer> frecuencia) {
        return frecuencia.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}
