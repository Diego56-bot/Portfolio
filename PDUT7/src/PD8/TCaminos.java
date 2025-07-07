package PD8;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author diego
 */
public class TCaminos {

    private Collection<PD4.TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }

    public String imprimirCaminos() {
        StringBuilder sb = new StringBuilder();
        for (PD4.TCamino camino : caminos) {
            sb.append(camino.imprimirEtiquetas() + "\n");
        }
        return sb.toString();
    }

    public void imprimirCaminosConsola() {
        System.out.println(imprimirCaminos());
    }

    public Collection<TCamino> getCaminos() {
        return caminos;
    }
}