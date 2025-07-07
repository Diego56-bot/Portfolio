package PD4;


public interface ICamino {

    boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);


    String imprimirEtiquetas();

}
