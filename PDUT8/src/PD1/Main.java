import PD1.TArista;
import PD1.TGrafoNoDirigido;
import PD1.TVertice;

import java.util.LinkedList;
import java.util.List;

public static void main(String[] args) {
    List<TVertice> vertices = new LinkedList<>();
    vertices.add(new TVertice("A"));
    vertices.add(new TVertice("B"));
    vertices.add(new TVertice("C"));
    vertices.add(new TVertice("D"));

    List<TArista> aristas = new LinkedList<>();
    aristas.add(new TArista("A", "B", 1));
    aristas.add(new TArista("A", "C", 4));
    aristas.add(new TArista("B", "C", 2));
    aristas.add(new TArista("B", "D", 5));
    aristas.add(new TArista("C", "D", 3));

    TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

    TGrafoNoDirigido mst = grafo.Prim();

    System.out.println("Resultado Prim:");
    for (TArista arista : mst.getLasAristas()) {
        System.out.println(arista.getEtiquetaOrigen() + " - " +
                arista.getEtiquetaDestino() + " : " +
                arista.getCosto());
    }
}
