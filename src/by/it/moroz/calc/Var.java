package by.it.moroz.calc;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Var implements Operation  {

    private static Map<String, Var> remember = new HashMap<>();

    static void saveVar(String name, Var var){
        remember.put(name, var);
    }

    static void printVar() {
        Set<Map.Entry<String, Var>> entries = remember.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    static void sortVar() {
        Map<String, Var> sorted = new TreeMap<>(remember);
        Set<Map.Entry<String, Var>> entries = sorted.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    public static Var createVar(String operand) throws CalcExeption {
        if(operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if(operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        if(remember.containsKey(operand)) return remember.get(operand);
        //TODO Replace on errors
        throw new CalcExeption("Переменная "+operand+" неопределена.");
        //return null;
    }


    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Сложение "+this+" на "+other+" невозможно.");
        //System.out.println("Сложение "+this+" на "+other+" невозможно.");
        //return null;
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw  new CalcExeption("Вычитание "+this+" на "+other+" невозможно.");
       // System.out.println("Вычитание "+this+" на "+other+" невозможно.");
        //return null;
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("Умножение "+this+" на "+other+" невозможно.");
        //System.out.println("Умножение "+this+" на "+other+" невозможно.");
        //return null;
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("Деление "+this+" на "+other+" невозможно.");
        //System.out.println("Деление "+this+" на "+other+" невозможно.");
        //return null;
    }

}
