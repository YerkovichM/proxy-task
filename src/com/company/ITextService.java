package com.company;

public interface ITextService {
    public String staticText();

    public String variable(String variable);

    public String exception(String text) throws RuntimeException;
}

