import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonMethodTest {

    public static void main(String[] args) throws Exception {

        Class<?> c1 = Class.forName("Person");
        Constructor<?> constructor = c1.getConstructor(String.class,int.class);
        Object object = constructor.newInstance("jack", 18);
        Method m1 = c1.getMethod("getName");
        System.out.println(m1.invoke(object));
    }

}
