package com.company;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        taskProxy();
    }

    public static void taskProxy() {
        ITextService textService = (ITextService)Proxy.newProxyInstance(
                TextService.class.getClassLoader(),
                TextService.class.getInterfaces(),
                new ProxyObject());
        System.out.println(textService.variable("server.port = ${port}"));
    }
}
