package PD8;


import java.util.Collection;
import java.util.LinkedList;


public class TCamino implements ICamino {

    private final PD8.TVertice origen;
    private Collection<Comparable> otrosVertices;
    // es una lista de etiquetas de los vertices
// ATENCIÓN: PONER LA CLASE CONCRETA QUE
// SEA MÁS APROPIADA
    private Double costoTotal = 0.0d;

    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
    }

    public TCamino(PD8.TVertice v) {
        this.origen = v;
        this.otrosVertices = new LinkedList();

    }

    @Override
    public boolean agregarAdyacencia(PD8.TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal = costoTotal + adyacenciaActual.getCosto();
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            costoTotal = costoTotal - adyacenciaActual.getCosto();
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public PD8.TVertice getOrigen() {
        return origen;
    }

    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    public void setOtrosVertices(Collection<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public boolean agregarAdyacencia(PD4.TAdyacencia adyacenciaActual) {
        return false;
    }

    @Override
    public TCamino copiar() {
        PD8.TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.costoTotal);
        return copia;
    }

    @Override
    public String imprimirEtiquetas() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(origen);
        for (Comparable c : otrosVertices) {
            cadena.append("->").append(c);
        }
        return cadena.toString();
    }
}