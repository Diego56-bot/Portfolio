public class Main {
    public static void main(String[] args) {
        Lista<String> miLista = new Lista<>();

        miLista.insertar(new Nodo<>("Hola", "clave1"));
        miLista.insertar(new Nodo<>("Diego", "clave2"));

        System.out.println("Elementos de la lista: " + miLista.imprimir(", "));
        System.out.println("Cantidad de elementos: " + miLista.cantElementos());

        System.out.println("¿Está vacía? " + miLista.esVacia());

        System.out.println("Buscando 'clave1': " + miLista.buscar("clave1").getDato());

        miLista.eliminar("clave1");
        System.out.println("Luego de eliminar 'clave1': " + miLista.imprimir(", "));
    }
}

