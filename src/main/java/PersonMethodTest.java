import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonMethodTest {

    public static void main(String[] args) throws Exception {

        Class<?> c1 = Class.forName("Person");
        Constructor<?> constructor = c1.getConstructor(String.class,int.class);
        Object object = constructor.newInstance("jack", 18);
        Method m1 = c1.getMethod("getName");
        System.out.println(m1.invoke(object));

        System.out.println("-----------");

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("方法修饰符: "+ method.getModifiers());
            System.out.println("方法返回值类型: "+ method.getReturnType());
            System.out.println("方法名称是: "+ method.getName());
            System.out.println("方法参数列表是: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType+" ");
            }
            System.out.println();
            System.out.println("异常类型列表是: ");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(exceptionType+" ");
            }
            System.out.println();
        }
    }

}
