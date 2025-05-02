import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Corchetes exp = new Corchetes();

        System.out.println(exp.controlCorchetes(Arrays.asList('{', '}', '{', '{', '}', '}'))); // verdadero
        System.out.println(exp.controlCorchetes(Arrays.asList('}', '{', '}', '}'))); // Falso
        System.out.println(exp.controlCorchetes(Arrays.asList('{', '{', '{', '}', '}'))); // Falso
        System.out.println(exp.controlCorchetes(Arrays.asList('{', '{', '}', '}', '{', '}', '{', '{', '}', '}'))); // verdadero
        System.out.println(exp.controlCorchetes(Arrays.asList('{', '{', '}', '{', '}'))); // Falso
    }
}
