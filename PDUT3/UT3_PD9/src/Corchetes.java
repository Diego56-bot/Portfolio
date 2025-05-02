import java.util.List;
import java.util.Stack;

public class Corchetes {

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();

        for (char caracter : listaDeEntrada) {
            if (caracter == '{') {
                pila.push(caracter);
            } else if (caracter == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }
}

