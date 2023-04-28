package next.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Constructor c:constructors) {
            logger.debug("constructor = {} " , c.getName());
        }
        for (Field f:fields) {
            logger.debug("field = {}" , f.getName());
        }
        for (Method m:methods) {
            logger.debug("methods = {}",m.getName());
        }
    }

    @Test
    @SuppressWarnings("rawtypes")
    public void constructor() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("paramer length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }

    @Test
    public void privateFieldAccess() throws Exception {
        Class<Student> clazz = Student.class;
        Student student = new Student();
        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");
        name.setAccessible(true);
        name.set(student, "이린");
        age.setAccessible(true);
        age.set(student, 120);

        logger.debug("name = {}, age = {}", student.getName(), student.getAge());

        clazz.getDeclaredMethods();
    }
}
