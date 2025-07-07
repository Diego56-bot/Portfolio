package PD9;

public class Cuentas {
    public static int factorial(int num) {
        if (num < 0) {
            System.out.println("No se puede calcular el factorial de un número negativo.");
            return -1;
        } else {
            int resultado = 1;
            for (int i = 2; i <= num; i++) {
                resultado *= i;
            }
            return resultado;
        }
    }

    public static boolean esPrimo(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }


    public static int sumaSegunPrimo(int num) {
        int suma = 0;
        if (esPrimo(num)) {
            int i = 0;
            while (i <= num) {
                if (i % 2 == 0) suma += i;
                i++;
            }
        } else {
            int i = 0;
            do {
                if (i % 2 != 0) suma += i;
                i++;
            } while (i <= num);
        }
        return suma;
    }
}




