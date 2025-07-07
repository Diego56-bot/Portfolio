package PD3;


import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;


    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList<>();
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
      private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char)(c + 'a'), palabras, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrie nodo = buscarNodoTrie(s);
        if (nodo !=  null && nodo.esPalabra) {
            return 1;
        }
        return 0;
    }

    public void agregarPagina(int pagina) {
        if (!paginas.contains(pagina)) {
            paginas.add(pagina);
        }
    }

    public TNodoTrie buscarNodo(String palabra) {
        return buscarNodoTrie(palabra);
    }


    public void imprimirIndice() {
        imprimirIndice("", this);

    }

    private void imprimirIndice(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.print(s + ": ");
                for (int pagina : nodo.paginas) {
                    System.out.print(pagina + " ");
                }
                System.out.println();
            }
            for (int c = 0; c < 26; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirIndice(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    public ResultadoBusqueda buscarMod (String palabra) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        for (int i = 0; i < palabra.length(); i++) {
            int indice =  palabra.charAt(i) - 'a';
            comparaciones++;
            if (nodo.hijos[indice] == null) {
                return new ResultadoBusqueda(false, comparaciones, new LinkedList<>());
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra) {
            return new ResultadoBusqueda(true, comparaciones, nodo.paginas);
        }
        else  {
            return new ResultadoBusqueda(false, comparaciones, new LinkedList<>());
        }
    }
}
