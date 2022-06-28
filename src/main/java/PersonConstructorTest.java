import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersonConstructorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 1. 使用原始方式以无参方式构造 Person 类对象并打印
        Person person = new Person();
        System.out.println("无参方式创建的对象是: "+ person);

        // 2. 使用反射机制以无参形式构造 Person 类型的对象并打印
        // 创建对象的类型看从键盘输入
//        System.out.println("请输入要创建对象的类型");
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
        // 创建对象的类型可以从配置文件中读取
        BufferedReader br = new BufferedReader(new FileReader("/Users/fengjian/study/temp/b.txt"));
        String str  = br.readLine();
        Class<?> p1 = Class.forName(str);
//        System.out.println("无参方式创建的对象是: "+ p1.newInstance());
        // 获取 Class 对象对应类中的无参构造方法，也就是 Person 类中的无参构造方法
        Constructor<?> constructor = p1.getConstructor();
        // 使用获取到的无参构造方法来构造对应类型的对象，也就是 Person 类型的对象
        System.out.println("无参方式构建的对象是: "+ constructor.newInstance());
//        scanner.close();
        br.close();

        // 3. 使用原始方式以有参方式构造 Person 类型的对象并打印
        Person p2 = new Person("jack", 18);
        System.out.println("有参方式构造的对象是: "+p2);


        // 4. 使用反射方式以有参方式构造 Person 类型对象并打印
        Constructor<?> constructor1 = p1.getConstructor(String.class, int.class);
        System.out.println("有参方式构造的对象是 "+constructor1.newInstance("rose", 16));

        // 5. 使用反射机制获取 Person 类中的所有公共构造方法
        Constructor<?>[] constructors = p1.getConstructors();
        for (Constructor<?> ct : constructors) {
            System.out.println("构造方法的访问修饰符是: "+ ct.getModifiers());
            System.out.println("构造方法的方法名称是: "+ ct.getName());
            Class<?>[] parameterTypes = ct.getParameterTypes();
            System.out.println("构造方法的所有参数类型是: ");
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType+" ");
            }
            System.out.println();
            System.out.println("-------------------");
        }


    }
}
