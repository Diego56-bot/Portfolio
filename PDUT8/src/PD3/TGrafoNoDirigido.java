package PD3;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        if(this.getVertices().isEmpty()) return null;
        TGrafoNoDirigido mst=new TGrafoNoDirigido(this.getVertices().values(),new LinkedList<TArista>());
        Set<Comparable> visitados=new HashSet<>();
        PriorityQueue<TArista> pq=new PriorityQueue<>(Comparator.comparingDouble(TArista::getCosto));

        TVertice inicio=this.getVertices().values().iterator().next();
        visitados.add(inicio.getEtiqueta());
        for (TArista arista:lasAristas) {
            if (arista.getEtiquetaOrigen().equals(inicio.getEtiqueta()) && !visitados.contains(arista.getEtiquetaDestino())) {
                pq.add(arista);
            }
            if (arista.getEtiquetaDestino().equals(inicio.getEtiqueta()) && !visitados.contains(arista.getEtiquetaOrigen())) {
                pq.add(new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto()));
            }
        }

        while(!pq.isEmpty()&&visitados.size()<this.getVertices().size()) {
            TArista aristaMin=pq.poll();

            if(visitados.contains(aristaMin.getEtiquetaDestino())) continue;
            mst.insertarArista(aristaMin);
            Comparable nuevoVertice=aristaMin.getEtiquetaDestino();
            visitados.add(nuevoVertice);
            for(TArista arista:lasAristas) {
                if(arista.getEtiquetaOrigen().equals(nuevoVertice)&&!visitados.contains(arista.getEtiquetaDestino())) {
                    pq.add(arista);
                }
            }
        }
        return mst;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
    public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
