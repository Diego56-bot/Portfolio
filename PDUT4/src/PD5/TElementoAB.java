package PD5;


import java.util.ArrayList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;


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

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;


    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;

    }

    public Comparable obtenerMenorClave() {
        if (hijoIzq == null) {
            return this.etiqueta;
        }
        else {
            return hijoIzq.obtenerMenorClave();
        }
    }

    public Comparable obtenerMayorClave() {
        if (hijoDer == null) {
            return this.etiqueta;
        }
        else {
            return hijoDer.obtenerMayorClave();
        }
    }


    public Comparable buscarAnterior(Comparable unaEtiqueta) {
        if (hijoDer != null && unaEtiqueta.equals(hijoDer.getEtiqueta())) {
            return this.etiqueta;
        }

        if (hijoIzq != null && unaEtiqueta.equals(hijoIzq.getEtiqueta())) {
            return this.etiqueta;
        }

        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscarAnterior(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscarAnterior(unaEtiqueta);
        } else {
            return null;
        }
    }

    public void listarHojas(TElementoAB<T> nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        if (nodo.hijoIzq == null && nodo.hijoDer == null) {
            System.out.println(nodo.getEtiqueta().toString() + " - " + nivel);
            return;
        }

        listarHojas(nodo.hijoIzq, nivel+1);
        listarHojas(nodo.hijoDer, nivel+1);
    }

    public int contarNodosNivel(TElementoAB nodo, int nivel){
        if (nodo == null){
            return 0;
        }

        int nodosIzq = contarNodosNivel(nodo.hijoIzq, nivel-1);
        int nodosDer = contarNodosNivel(nodo.hijoDer, nivel-1);

        if (nivel == 0) {
            return 1;
        }

        return nodosIzq + nodosDer;
    }

    public boolean esDeBusqueda() {
        ArrayList<Comparable> elementosInorden = new ArrayList<>();
        inOrden((ArrayList<T>) elementosInorden);

        for (int i = 1; i < elementosInorden.size(); i++) {
            int comparacion = elementosInorden.get(i).compareTo(elementosInorden.get(i - 1));
            if (comparacion <= 0) {
                return false;
            }
        }
        return true;
    }


    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {

            return false;
        }
    }


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

    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }


    public void inOrden(ArrayList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }


    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }


    @Override
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



    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
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

        return elHijo;
    }

    public int obtenerTamanio() {
        int tam = 1;
        if (this.getHijoIzq() != null) {
            tam += this.getHijoIzq().obtenerTamanio();
        }
        if (this.getHijoDer() != null) {
            tam += this.getHijoDer().obtenerTamanio();
        }
        return tam;
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
    public String postOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += hijoIzq.postOrden() + "-";
        }
        if (hijoDer != null) {
            resultado += hijoDer.postOrden() + "-";
        }
        resultado += this.getDatos().toString();
        return resultado;
    }

    public int alturaAux() {
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        } else {
            int izq = (this.hijoIzq != null) ? this.hijoIzq.alturaAux() : -1;
            int der = (this.hijoDer != null) ? this.hijoDer.alturaAux() : -1;
            return 1 + Math.max(izq, der);
        }

    }



}
