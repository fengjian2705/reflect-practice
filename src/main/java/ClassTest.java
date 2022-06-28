public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {

        // 1. 使用数据类型.class 的方式可以获取对应的 Class 对象
        Class<String> clazz = String.class;
        System.out.println("clazz "+ clazz);// 自动调用 toString 方法 class java.lang.String

        System.out.println(int.class);
        System.out.println(void.class);

        // 2. 使用对象.getClass() 获取 Class 对象
        String  str1 = new String();
        System.out.println(str1.getClass());
        Integer integer = new Integer(2);
        System.out.println(integer.getClass());
        int num = 3;
//        num.getClass() error 基本类型

        // 3. 使用包装类.TYPE 方式获取 Class 对象
        System.out.println(Integer.TYPE);
        System.out.println(Long.TYPE);

        // 4. 调用 Class 类中的 forName(类全路径：包名.类名) 方法来获取 Class 对象
        Class<?> string = Class.forName("java.lang.String");
        System.out.println(string);
        Class<?> date = Class.forName("java.util.Date");
        System.out.println(date);
//        Class.forName("int"); error 不能获取基本类型的 Class 对象

        // 5. 使用类加载器 ClassLoader 获取 Class 对象
//        ClassLoader classLoader = String.class.getClassLoader();// null
        ClassLoader classLoader = ClassTest.class.getClassLoader();// null
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass);


    }
}
