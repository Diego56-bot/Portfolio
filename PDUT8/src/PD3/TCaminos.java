package PD3;/*

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author diego
 */

import java.util.Collection;
import java.util.LinkedList;

public class TCaminos {
    
    private Collection<TCamino> caminos;

    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()+"\n");
        }
        return sb.toString();
    }

    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }

    public Collection<TCamino> getCaminos() {
        return caminos;
    }
    public void agregarCamino(TCamino camino){
        this.caminos.add(camino);
    }


}
