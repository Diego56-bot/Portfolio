import java.util.List;

public class Trie {
    private NodoTrie raiz;
    public Trie() {
        raiz = new NodoTrie();
    }
    public void insertar(Trie trie, String palabra, int pagina) {
        if (raiz == null) {
            raiz = new NodoTrie();
        }
        raiz.insertar(raiz, palabra, 0, pagina);
    }
    public void mostrarIndice() {
        if (raiz != null) {
            raiz.construirIndice(raiz, "");
        }
    }
    // Ejercicio 2:
    public List<Integer> buscar(String palabra) {
        if (raiz == null) return null;
        return raiz.buscar(raiz, palabra, 0);
    }    
}
