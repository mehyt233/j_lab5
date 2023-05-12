package com.jva;

import com.jva.injection.Injector;
import com.jva.injection.SomeBean;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String properties = "prop1.properties";
        Injector injector = new Injector(properties);
        SomeBean someBean = injector.inject(new SomeBean());
        someBean.foo();

        System.out.println("--------------");

        //Другие настройки
        String properties2 = "prop2.properties";
        injector.setPropertiesString(properties2);
        someBean = injector.inject(new SomeBean());
        someBean.foo();
    }
}
