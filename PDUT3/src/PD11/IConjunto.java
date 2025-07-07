package PD11;

import PD7.ILista;

public interface IConjunto<T>  {
    public Conjunto union (Conjunto otroConjunto);
    public Conjunto interseccion (Conjunto otroConjunto);
}