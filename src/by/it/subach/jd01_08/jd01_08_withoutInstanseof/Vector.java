package by.it.subach.jd01_08.jd01_08_withoutInstanseof;

import java.util.Arrays;

public class Vector extends Var {

    public double[] getValue() {
        return value;
    }

    private double[] value;


    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] str = strVector.split(",");
        this.value = new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add(Var other) {
        return other.add2(this);
    }

    @Override
    public Var sub(Var other) {
        return other.sub2(this);
    }

    @Override
    public Var mul(Var other) {
        return other.mul2(this);
    }

    @Override
    public Var div(Var other) {
        return other.div2(this);
    }


    //    Vector + Vector
    @Override
    public Var add2(Vector other) {
        double[] res = Arrays.copyOf(this.getValue(), this.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] += other.getValue()[i];
        }
        return new Vector(res);
    }

    //    Vector - Vector
    @Override
    public Var sub2(Vector other) {
        if (other.value.length != this.value.length) {
            return other.sub(this);
        } else {
            double[] res = Arrays.copyOf(other.value, other.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= (this).getValue()[i];
            }
            return new Vector(res);
        }
    }

    //    Vector * Vector
    @Override
    public Var mul2(Vector other) {
        if (((Vector) other).value.length == this.value.length) {
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(this);
    }

    @Override
    public Var mul2(Matrix other) {
        int vectorLength = this.getValue().length;
        if (this.value.length == vectorLength) {
            double[] res = new double[vectorLength];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i] += other.getValue()[i][j] * this.getValue()[j];
                }
            }
            return new Vector(res);
        }
        return super.mul(other);

    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }

        out.append('}');
        return out.toString();
    }


}
