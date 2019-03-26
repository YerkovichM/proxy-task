package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProxyObject implements InvocationHandler {

    private static Method variableMethod;

    static {
        try {
            variableMethod = TextService.class.getMethod("variable", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        if (m.getName().equals(variableMethod.getName())) {
            return proxyVariable((String) args[0]);
        } else {
            throw new InternalError(
                    "unexpected Object method dispatched: " + m);
        }
    }

    protected String proxyVariable(String args) {
        Matcher m = Pattern.compile("\\$\\{(.*?)}").matcher(args);
        if (m.find()) {
            String res = System.getProperty(m.group(1), "");
            return m.replaceFirst(res);
        }
        return null;
    }
}
