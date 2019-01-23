package by.it.a_khmelev.calc_v3_with_log_and_savevars;

interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other)  throws CalcException;

    Var mul(Var other)  throws CalcException;

    Var div(Var other)  throws CalcException;
}