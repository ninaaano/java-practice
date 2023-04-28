package next.reflection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Junit3TestRunner {
    @Test
    public void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        Junit3Test junit3Test = clazz.getDeclaredConstructor().newInstance();

        Arrays.stream(declaredMethods).filter(m -> m.getName().startsWith("test"))
                .forEach(m -> {
                    try {
                        m.invoke(junit3Test);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
