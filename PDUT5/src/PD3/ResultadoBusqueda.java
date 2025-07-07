package PD3;

import java.util.LinkedList;

public class ResultadoBusqueda {
    public boolean encontrada;
    public int comparaciones;
    public LinkedList<Integer> paginas;

    public ResultadoBusqueda(boolean encontrada, int comparaciones, LinkedList<Integer> paginas) {
        this.encontrada = encontrada;
        this.comparaciones = comparaciones;
        this.paginas = paginas;
    }
}
