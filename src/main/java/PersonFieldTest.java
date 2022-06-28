import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PersonFieldTest {

    public static void main(String[] args) throws Exception{

        // 1. 使用原始方式来狗仔对象以及获取成员变量的数值并打印
        Person p1 = new Person("jack",18);
        System.out.println("获取到的成员变量数值为: "+p1.getName());

        System.out.println("----------------------");

        // 2. 使用反射机制来构造对象以及获取成员变量的数值并打印
        // 2.1 获取 Class 对象
        Class<?> c1 = Class.forName("Person");
        // 2.2 根据 Class 对象获取对应的有参构造方法
        Constructor<?> constructor = c1.getConstructor(String.class, int.class);
        // 2.3 使用有参构造方法得到 Person 类对象
        Object object = constructor.newInstance("rose", 16);
        // 2.4 根据 Class 对象获取对应的成员变量信息
        Field field = c1.getDeclaredField("name");
        // 取消 java 语言访问检查
        field.setAccessible(true);
        // 2.5 使用 Person 类型的对象来获取成员变量的数值
        System.out.println("获取到的成员变量是: "+field.get(object));

        System.out.println("------------------------");
        // 3. 使用原始方式修改指定对象的成员碧莲的数值后并打印
        p1.setName("东方不败");
        System.out.println("修改后的成员变量值是: "+ p1.getName());

        System.out.println("-------------------------");
        // 4. 使用反射机制修改成员变量的值
        field.set(object,"令狐冲");
        System.out.println("修改后成员变量的值是: "+ field.get(object));

    }
}
