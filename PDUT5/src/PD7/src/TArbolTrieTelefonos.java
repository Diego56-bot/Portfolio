import java.util.LinkedList;

public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    public TArbolTrieTelefonos() {
        this.raiz = new TNodoTrieTelefonos();
    }

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        String prefijo = pais + area;
        LinkedList<TAbonado> lista = new LinkedList<>();
        raiz.buscarTelefonos(prefijo, lista);
        return lista;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        raiz.insertar(unAbonado);
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el árbol trie:");
        raiz.imprimir();
    }

    public TNodoTrieTelefonos getRaiz() {
        return raiz;
    }

    public TNodoTrieTelefonos[] getHijos() {
        return raiz.getHijos();
    }
    public LinkedList<TAbonado> getAbonados(){
        return raiz.getAbonados();
    }
}
