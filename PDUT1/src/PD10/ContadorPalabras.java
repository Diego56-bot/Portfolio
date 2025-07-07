package PD10;

public class ContadorPalabras {

    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras1.length; i++) {
            for (int j = 0; j < palabras2.length; j++) {
                if (palabras1[i].equals(palabras2[j])) {
                    resultado.append(palabras1[i]).append(" ");
                    break;
                }
            }
        }
        return resultado.toString().trim().split(" ");
    }
}
