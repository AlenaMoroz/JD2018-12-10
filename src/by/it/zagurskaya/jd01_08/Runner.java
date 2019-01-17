package by.it.zagurskaya.jd01_08;

import by.it.zagurskaya.jd01_08.Matrix;
import by.it.zagurskaya.jd01_08.Vector;
import by.it.zagurskaya.jd01_08.Scalar;

public class Runner {
    private static void print(Var var) {System.out.println(var);}
    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var s1 = new Scalar(4.0);
        Var s2 = new Scalar(5.0);
        Var v = new Vector(new double[]{1,2,3}); // закомментируйте вектор и/или
        Var v1 = new Vector(new double[]{2,2,2}); // закомментируйте вектор и/или
        Var v2 = new Vector(new double[]{1,2,3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
/* Уровень сложности A (калькулятор) */
        print(s.add(s)); //выведет в консоль 6.0
        print(s1.add(s2)); //выведет в консоль 9.0
        print(s2.add(s1)); //выведет в консоль 9.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0
/* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(v.add(s));
        print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        print(v.add(v1));
        print(v2.add(v1));
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.mul(s));
        print(v.mul(v)); //выведет в консоль 14.0
        print(v.div(v)); //сообщит о невозможности операции
/* Уровень сложности C (матричные операции и умножение на вектор)
закомментируйте, если не реализовали */
        print(m.add(s)); //{{4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}, {10.0, 11.0, 12.0}}
        print(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        //????????????????
        Var s11 = new Scalar(1.0);
        Var m11 = new Matrix("{{1,2},{3,4}}");// матрицу, если вы их не реализовали
        print(m11.add(s11));//{{2.0, 3.0}, {4.0, 5.0}}
        print(m11.sub(s11));//{{0.0, 1.0}, {2.0, 3.0}}
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
        print(m.mul(s)); //{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}, {21.0, 24.0, 27.0}}
    }

}