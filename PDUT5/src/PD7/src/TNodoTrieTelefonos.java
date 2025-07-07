import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {
    private static final int CANT_DIGITOS = 10;
    private TNodoTrieTelefonos[] hijos;
    private LinkedList<TAbonado> abonados;



    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[CANT_DIGITOS];
        abonados = new LinkedList<>();
    }
    public TNodoTrieTelefonos[] getHijos(){
        return hijos;
    }
    public LinkedList<TAbonado> getAbonados(){
        return abonados;
    }
    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        String numero = unAbonado.getTelefono();

        for (int i = 0; i < numero.length(); i++) {
            char c = numero.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("Número inválido: " + numero);
                return;
            }

            int indice = c - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }

        nodo.abonados.add(unAbonado);
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonadosEncontrados) {
        TNodoTrieTelefonos nodo = this;

        for (int i = 0; i < primerosDigitos.length(); i++) {
            char c = primerosDigitos.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }

            int indice = c - '0';
            if (nodo.hijos[indice] == null) {
                return;
            }
            nodo = nodo.hijos[indice];
        }

        nodo.recorrerYAgregar(abonadosEncontrados);
    }

    private void recorrerYAgregar(LinkedList<TAbonado> lista) {
        lista.addAll(this.abonados);
        for (TNodoTrieTelefonos hijo : hijos) {
            if (hijo != null) {
                hijo.recorrerYAgregar(lista);
            }
        }
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < CANT_DIGITOS; i++) {
            if (hijos[i] != null) {
                hijos[i].imprimir();
            }
        }

        for (TAbonado abonado : abonados) {
            System.out.println("Nombre: " + abonado.getNombre() + " - Teléfono: " + abonado.getTelefono());
        }
    }
}
