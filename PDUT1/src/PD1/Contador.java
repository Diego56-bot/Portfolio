package PD1;

public class Contador {
    private final int MAX_CONT = 50;
    private int incremento = 1;
    private int contador = 1;

    public void displayCountWhile() {
        while (contador <= MAX_CONT) {
            System.out.println(contador);
            contador = contador + incremento;
        }
    }

    public void contadorWhile() {
        contador = 1;
        do {
            System.out.println(contador);
            contador = contador + incremento;
        } while (contador <= MAX_CONT);
    }

    public void contadorFor() {
        for (int i = 1; i <= MAX_CONT; i += incremento) {
            System.out.println(i);
        }
    }


}
