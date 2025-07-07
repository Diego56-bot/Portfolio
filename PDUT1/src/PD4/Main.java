package PD4;
public class Main{
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
        //Ejercicio 3:
        NumberHolder nh = new NumberHolder();
        nh.anInt = 10;
        nh.aFloat = 5.5f;
        System.out.println("anInt: " + nh.anInt);
        System.out.println("aFloat: " + nh.aFloat);
    }


}



