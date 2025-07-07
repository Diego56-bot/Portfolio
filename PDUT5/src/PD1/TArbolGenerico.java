package PD1;

public class TArbolGenerico<T> implements IArbolGenerico {
    private TElementoAG<T> raiz;

    public boolean insertar(Comparable etiq, Comparable etiquetaPadre) {
        if (raiz == null){
            raiz = new TElementoAG<T>(etiq);
            return true;
        }

        return raiz.insertar(etiq, etiquetaPadre);
    }


    public TElementoAG<T> buscar(Comparable etiq) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(etiq);
    }
}
