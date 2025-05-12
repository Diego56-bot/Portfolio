public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer
                = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }


    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(elemento);
            } else {
                hijoIzq = elemento;
                return true;
            }
        }
        if (elemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(elemento);
            } else {
                hijoDer = elemento;
                return true;
            }
        } else {
            return false;
        }
    }
    @Override
    public String preOrden() {
        String resultado = this.getDatos().toString();

        if (hijoIzq != null) {
            resultado += "-" + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            resultado += "-" + hijoDer.preOrden();
        }
        return resultado;
    }

    @Override
    public String inOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += "-" + hijoIzq.inOrden();
        }
        resultado = this.getDatos().toString();

        if (hijoDer != null) {
            resultado += "-" + hijoDer.inOrden();
        }
        return resultado;
    }
    public String postOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += "-" + hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            resultado += "-" + hijoDer.postOrden();
        }
        resultado = this.getDatos().toString();
        return resultado;
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }


    /**
     * Auxiliar para eliminar(), maneja los casos de eliminación de nodos
     * Casos: es hoja, tiene un hijo sólo, o es nodo interior completo
     * @return -> retorna el nodo a eliminar
     */
    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }
        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // El nodo tiene dos hijos, se busca el nodo lexicográficamente anterior
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }
        elHijo.setHijoDer(hijoDer);

        // Se desconectan los hijos del nodo actual para facilitar el trabajo del recolector de basura
        setHijoIzq(null);
        setHijoDer(null);

        return elHijo;
    }
}