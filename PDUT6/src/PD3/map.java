package PD3;

import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class map {
    public static Map<String, String> intercambio(Map<String, String> original) {
        Map<String, String> invertido = new HashMap<>();
        for (Map.Entry<String, String> entry : original.entrySet()) {
            String clave = entry.getKey();
            String valor = entry.getValue();

            if (invertido.containsKey(valor)) {
                throw new IllegalArgumentException("Valor duplicado encontrado: " + valor);
            }
            invertido.put(valor, clave);
        }
        return invertido;
    }
    public static List<String> ordenarCadenas(List<String> cadenas) {
        List<String> resultado = new ArrayList<>(cadenas);
        resultado.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        return resultado;
    }



}
