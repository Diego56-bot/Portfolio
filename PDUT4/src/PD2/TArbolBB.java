package PD2;

public class TArbolBB<T>  implements IArbolBB<T>
{
    private int contador;
    protected TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista.
     */

    public TArbolBB() {
        raiz = null;
    }


    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = (TElementoAB<T>) unElemento;
            contador++;  // Incrementamos el contador
            System.out.println("Elemento insertado. Contador de inserciones: " + contador);
            return true;
        } else {
            boolean resultado = raiz.insertar((TElementoAB<T>) unElemento);
            if (resultado) {
                contador++;  // Incrementamos el contador
                System.out.println("Elemento insertado. Contador de inserciones: " + contador);
            }
            return resultado;
        }
    }

    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }

    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public String inOrden() {
        if(!esVacio()) {
            return raiz.inOrden();
        }
        return "";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if(!esVacio()) {
            return raiz.preOrden();
        }
        return "";
    }


    @Override
    public String postOrden() {
        if(!esVacio()) {
            return raiz.postOrden();
        }
        return "";
    }

}
