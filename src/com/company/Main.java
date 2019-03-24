package com.company;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        taskProxy();
    }

    public static void taskProxy() {
        IVariableMethod method = (IVariableMethod) Proxy.newProxyInstance(
                TextService.class.getClassLoader(),
                new Class[]{IVariableMethod.class},
                new ProxyObject());
        System.out.println(method.variable("server.port = ${port}"));
    }
}
