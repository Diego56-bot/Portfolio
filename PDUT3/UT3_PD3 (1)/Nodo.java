public class Nodo<T> implements INodo<T> {

    private T dato;
    private Nodo<T> siguiente;
    private Comparable etiqueta;

    public Nodo(T dato, Comparable etiqueta) {
        this.dato = dato;
        this.etiqueta = etiqueta;
        this.siguiente = null;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public T getDato() {
        return dato;
    }
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(dato);
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

}
