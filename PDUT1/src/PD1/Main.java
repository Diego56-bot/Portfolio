package PD1;


public class Main{

    public static void main(String[] args) {

        Multsuma.multsuma(1.0, 2.0, 3.0);
        Multsuma.multsuma(4.0, 5.0, 6.0);

        Contador contador = new Contador();
        System.out.println("While:");
        contador.displayCountWhile();
        System.out.println("Do-While:");
        contador.contadorWhile();
        System.out.println("For:");
        contador.contadorFor();


    }

}



