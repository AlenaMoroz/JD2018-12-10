package by.it.kushnerov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        double f = 0;
        for (int x = 1; x <= 6; x++) {
            for (double a = 0; a <= 2; a=a+0.2) {
                f = pow(7, a) - cos(x);
            }
            y = y +f;
        }
        System.out.println("y=" +y);
    }

    private static void step2() {
        double a = 0;
        double b = 0;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if ((x / 2 > -2) && (x / 2 <= -1)) {
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("При x/2="+x/2+" a="+a);
            } else if ((x / 2 > -1) && (x / 2 < 0.2)) {
                b = cos(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("При x/2="+x/2+" a="+a);
            } else if(x/2==0.2){
                b = 1 / tan(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("При x/2="+x/2+" a="+a);
            }else{
                System.out.println("При x/2="+x/2+" вычисления не определены");
            }
        }
    }
}


