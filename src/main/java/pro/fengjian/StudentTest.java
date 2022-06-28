package pro.fengjian;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class StudentTest {

    public static void main(String[] args) throws Exception{

        Class<?> c1 = Class.forName("pro.fengjian.Student");
        System.out.println("包: "+ c1.getPackage());
        System.out.println("父类: "+ c1.getSuperclass());
        System.out.println("接口: ");
        Class<?>[] interfaces = c1.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.print(anInterface+" ");
        }
        System.out.println();
        System.out.println("注解: ");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.print(annotation+" ");
        }
        System.out.println();
        System.out.println("泛型: ");
        Type[] genericInterfaces = c1.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            System.out.print(genericInterface+" ");
        }
        System.out.println();
    }
}
