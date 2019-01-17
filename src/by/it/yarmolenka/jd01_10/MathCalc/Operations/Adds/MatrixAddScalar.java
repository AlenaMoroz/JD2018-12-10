package by.it.yarmolenka.jd01_10.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

import java.util.Arrays;

public class MatrixAddScalar {
    public static Matrix matrixScalar(Matrix m, Scalar sc) {
        double[][] res = new double[m.value.length][m.value[0].length];
        for (int i = 0; i < res.length; i++) res[i] = Arrays.copyOf(m.value[i], m.value[i].length);
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++)
                res[i][j] += sc.value;
        return new Matrix(res);
    }
}
