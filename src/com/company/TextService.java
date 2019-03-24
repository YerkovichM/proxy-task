package com.company;

public class TextService implements IVariableMethod {


    public String staticText() {
        return "Some static text";
    }

    @Override
    public String variable(String variable) {
        return variable;
    }

    public String exception(String text) throws RuntimeException {
        throw new RuntimeException();
    }
}
