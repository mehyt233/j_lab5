package com.jva.injection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class InjectorTest {

    @Test
    @DisplayName("Тест для обоих properties")
    void inject() {
        try{
            Field field1 = SomeBean.class.getDeclaredField("field1");
            Field field2 = SomeBean.class.getDeclaredField("field2");
            field1.setAccessible(true);
            field2.setAccessible(true);

            String properties = "prop1.properties";
            Injector injector = new Injector(properties);
            SomeBean someBean = injector.inject(new SomeBean());
            //проверяем на правильность инициализации
            assertTrue(field1.get(someBean) instanceof SomeImpl);
            assertTrue(field2.get(someBean) instanceof SODoer);

            //пробуем с другими настройками
            String properties2 = "prop2.properties";
            injector.setPropertiesString(properties2);
            someBean = injector.inject(new SomeBean());
            //проверяем на правильность инициализации
            assertTrue(field1.get(someBean) instanceof SomeOtherImpl);
            assertTrue(field2.get(someBean) instanceof SODoer);
        }
        catch (Exception e){
            fail("Возникло исключение "+ e);
        }
    }
}