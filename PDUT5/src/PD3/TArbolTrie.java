package PD3;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        return (raiz != null) ? raiz.buscar(palabra) : 0;
    }


    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> resultados = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, resultados);
        }
        return resultados;
    }

    public TNodoTrie buscarNodo(String palabra) {
        if (raiz == null) return null;
        return raiz.buscarNodo(palabra);
    }

    public void imprimirIndice() {
        if (raiz != null) {
            raiz.imprimirIndice();
        }
    }

    public ResultadoBusqueda buscarMod(String palabra) {
        if (raiz != null) {
            return raiz.buscarMod(palabra);
        }
        return new ResultadoBusqueda(false, 0, new LinkedList<>());
    }
}
