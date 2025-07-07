package PD2.src;

import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {
    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private Double[][] distanciasFloyd;
    private int[][] predecesoresFloyd;
    private List<TVertice> adyacentes;


    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double excentricidadMinima=Double.MAX_VALUE;
        IVertice verticeCentro= null;
        for (IVertice vertice : this.vertices.values()) {
            Double excentricidadMaxima= (Double) obtenerExcentricidad(vertice.getEtiqueta());
            if(excentricidadMaxima<excentricidadMinima){
                excentricidadMinima=excentricidadMaxima;
                verticeCentro=vertice;
            }
        }
        if (verticeCentro!= null) {
            return verticeCentro.getEtiqueta();
        }
        return null;
    }

    @Override
    public Double[][] floyd() {
        int n= vertices.size();
        Object[] etiquetas=getEtiquetasOrdenado();
        distanciasFloyd= new Double[n][n];
        predecesoresFloyd=new int[n][n];
        for (int i= 0; i < n;i++) {
            for (int j= 0; j< n;j++) {
                if (i== j) {
                    distanciasFloyd[i][j]= 0.0;
                    predecesoresFloyd[i][j]= -1;
                } else {
                    IVertice vi= buscarVertice((Comparable) etiquetas[i]);
                    IAdyacencia ady=vi.buscarAdyacencia((Comparable) etiquetas[j]);
                    distanciasFloyd[i][j]=(ady != null) ? ady.getCosto(): Double.MAX_VALUE;
                    predecesoresFloyd[i][j]= (ady!=null) ? i:-1;
                }
            }
        }
        for (int k= 0; k < n; k++) {
            for (int i= 0; i < n; i++) {
                for (int j= 0; j < n; j++) {
                    if (distanciasFloyd[i][k]!= Double.MAX_VALUE && distanciasFloyd[k][j]!= Double.MAX_VALUE) {
                        double nuevo= distanciasFloyd[i][k] + distanciasFloyd[k][j];
                        if (nuevo< distanciasFloyd[i][j]) {
                            distanciasFloyd[i][j]= nuevo;
                            predecesoresFloyd[i][j]= predecesoresFloyd[k][j];
                        }
                    }
                }
            }
        }
        return distanciasFloyd;
    }

    public Double getDistanciaFloyd(String origen, String destino) {
        Object[] etiquetas= getEtiquetasOrdenado();
        int i= Arrays.asList(etiquetas).indexOf(origen);
        int j= Arrays.asList(etiquetas).indexOf(destino);
        if (i== -1|| j== -1) return null;
        return distanciasFloyd[i][j];
    }
    public List<String> getItinerarioFloyd(String origen, String destino) {
        Object[] etiquetas= getEtiquetasOrdenado();
        int i= Arrays.asList(etiquetas).indexOf(origen);
        int j= Arrays.asList(etiquetas).indexOf(destino);

        if (i==-1 || j==-1 || distanciasFloyd[i][j]==Double.MAX_VALUE) {
            return Collections.emptyList();
        }

        LinkedList<String> camino=new LinkedList<>();
        reconstruirCamino(i, j, etiquetas, camino);
        if (camino.isEmpty()||!camino.getFirst().equals(origen)) {
            return Collections.emptyList();
        }
        return camino;
    }


    private void reconstruirCamino(int i, int j, Object[] etiquetas, LinkedList<String> camino) {
        if (i== j) {
            camino.addFirst(etiquetas[i].toString());
        } else if (predecesoresFloyd[i][j]== -1) {
        } else {
            reconstruirCamino(i, predecesoresFloyd[i][j], etiquetas, camino);
            camino.add(etiquetas[j].toString());
        }
    }


    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        IVertice vertice= this.buscarVertice(etiquetaVertice);
        if (vertice== null) {
            return -1d;
        }

        Map<Comparable, Double> distancias= new HashMap<>();
        for (Comparable etiqueta: this.vertices.keySet()) {
            distancias.put(etiqueta, Double.POSITIVE_INFINITY);
        }
        distancias.put(etiquetaVertice,0d);

        PriorityQueue<IVertice> cola= new PriorityQueue<>(Comparator.comparingDouble(v -> distancias.get(v.getEtiqueta())));
        cola.add(vertice);

        while (!cola.isEmpty()) {
            IVertice actual= cola.poll();
            for (IAdyacencia ady: actual.getAdyacentes()) {
                IVertice destino= ady.getDestino();
                double nuevoCosto= distancias.get(actual.getEtiqueta()) + ady.getCosto();
                if (nuevoCosto < distancias.get(destino.getEtiqueta())) {
                    distancias.put(destino.getEtiqueta(), nuevoCosto);
                    cola.add(destino);
                }
            }
        }
        double excentricidad= 0d;
        for (double d: distancias.values()) {
            if (d!= Double.POSITIVE_INFINITY && d>excentricidad) {
                excentricidad=d;
            }
        }

        return excentricidad;
    }

    public boolean[][] warshall() {
        int n= vertices.size();
        Object[] etiquetas= getEtiquetasOrdenado();
        boolean[][] accesibilidad= new boolean[n][n];

        for (int i= 0; i< n; i++) {
            IVertice vi= buscarVertice(etiquetas[i].toString());
            for (int j= 0; j < n;j++) {
                if (i== j) {
                    accesibilidad[i][j]= true;
                } else {
                    IAdyacencia ady= vi.buscarAdyacencia((Comparable) etiquetas[j]);
                    accesibilidad[i][j]= (ady != null);
                }
            }
        }
        for (int k= 0; k < n; k++) {
            for (int i= 0; i < n; i++) {
                for (int j= 0; j < n; j++) {
                    accesibilidad[i][j]= accesibilidad[i][j] || (accesibilidad[i][k] && accesibilidad[k][j]);
                }
            }
        }

        return accesibilidad;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        IVertice vertice= buscarVertice(nombreVertice);
        if (vertice== null) {
            return false;
        }
        else {
            for(IVertice v:vertices.values()){
                v.eliminarAdyacencia(nombreVertice);
            }
        }
        vertices.remove(nombreVertice);
        return true;
    }


}
