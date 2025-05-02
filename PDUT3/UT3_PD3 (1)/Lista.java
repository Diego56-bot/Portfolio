public class Lista<T> implements ILista<T> {
    private Nodo<T> primero;

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }
    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato, etiqueta);
        insertar(nuevoNodo);
    }

    @Override
    public void setPrimero( Nodo<T> unNodo) {
        primero = unNodo;
    }
    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> aux = primero;
        while (aux != null && !aux.getDato().equals(clave)) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    @Override
    public boolean eliminar(Comparable clave) {
        Nodo<T> aux = primero;
        Nodo<T> anterior = null;
        while (aux != null && !aux.getDato().equals(clave)) {
            anterior = aux;
            aux = aux.getSiguiente();

        }
        if (aux == null) {
            return false;
        }

        if (anterior == null) {
            primero = aux.getSiguiente();
        } else {
            anterior.setSiguiente(aux.getSiguiente());
        }
        return true;
    }
    @Override
    public String imprimir() {
        String resultado = "";
        Nodo<T> aux = primero;

        while (aux != null) {
            resultado += aux.getEtiqueta();
            aux = aux.getSiguiente();
        }

        return resultado;
    }
    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> aux = primero;

        while (aux != null) {
            resultado += aux.getEtiqueta();

            if (aux.getSiguiente() != null) {
                resultado += separador;
            }

            aux = aux.getSiguiente();
        }

        return resultado;
    }
    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> aux = primero;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }


}
