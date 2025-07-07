package PD1;

public interface IElementoAG<T> {
    public Comparable getEtiqueta();
    public void setEtiqueta(Comparable etiqueta);

    public TElementoAG<T> getPrimerHijo();
    public void setPrimerHijo(TElementoAG<T> primerHijo);

    public TElementoAG<T> getHermano();
    public void setHermano(TElementoAG<T> hermano);

    public TElementoAG<T> buscar(Comparable etiq);
    public boolean insertar(Comparable etiq, Comparable etiquetaPadre);
}

