import java.util.ArrayList;
import java.util.List;

public class NodoTrie {
    public NodoTrie[] hijos;
    public boolean esPalabra;
    public List<Integer> paginas;

    public NodoTrie() {
        hijos = new NodoTrie[26];
        esPalabra = false;
        paginas = new ArrayList<>();
    }

    public void insertar(NodoTrie nodo, String palabra, int indice, int pagina) {
        if (indice == palabra.length()) {
            nodo.esPalabra = true;
            if (!nodo.paginas.contains(pagina)) {
                nodo.paginas.add(pagina);
            }
            return;
        }
        char caracter = Character.toLowerCase(palabra.charAt(indice));
        int posicion = caracter - 'a'; /* indice de la letra */
        if (nodo.hijos[posicion] == null) {
            nodo.hijos[posicion] = new NodoTrie();
        }
        insertar(nodo.hijos[posicion], palabra, indice + 1, pagina);

    }

    public void construirIndice(NodoTrie nodo, String palabraActual) {
        if (nodo.esPalabra) {
            System.out.println(palabraActual + " " + nodo.paginas);
        }
        for (int i = 0; i < 26; i++) { /* recorre todos los hijos */
            if (nodo.hijos[i] != null) {
                char siguienteLetra = (char) ('a' + i);
                construirIndice(nodo.hijos[i], palabraActual + siguienteLetra); /*Crea la palabra*/
            }
        }
    }
    //Ejercicio 2:
    public List<Integer> buscar(NodoTrie nodo, String palabra, int indice) {
        if (indice == palabra.length()) {
            if (nodo.esPalabra) {
                return nodo.paginas;
            } else {
                return null;
            }
        }
    
        char caracter = Character.toLowerCase(palabra.charAt(indice));
        int posicion = caracter - 'a';
    
        if (nodo.hijos[posicion] == null) {
            return null;
        }
    
        return buscar(nodo.hijos[posicion], palabra, indice + 1);
    }
}
