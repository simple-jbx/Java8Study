package reflection;

import org.junit.Test;
import tech.snnukf.java8study.pojo.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * //TODO... Description
 *
 * @className: ReflectionTest
 * @author: simple.jbx
 * @date: 2022/10/16
 **/
public class ReflectionTest {

    /**
     * 反射 Person操作
     * @param: null
     * @return: 
     * @author: simple.jbx
     * @date: 2022/10/16 19:55
     */
    @Test
    public void test01() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        //1. 通过反射可以创建对象
        Class clazz = Class.forName("tech.snnukf.java8study.pojo.Person");
        Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);
        Object obj = constructor.newInstance("Tom", 18, "aka");
        Person person = (Person) obj;
        System.out.println(person);

        //2. 通过反射调用对象指定的属性、方法
        Field nickName = clazz.getDeclaredField("nickName");
        nickName.set(person, "simple");
        System.out.println(person);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("**********************************");
        //通过反射调用Person类的私有结构，私有构造器、属性、方法
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class, int.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("simple", 23);
        System.out.println(p1);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Bob");
        System.out.println(p1);
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "china");
    }

    @Test
    public void test02() {
        Class clazz = Person.class;
        //获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println("*****************************");

        //获取当前运行时类的所有属性（不包含父类的属性）
        Field[] decFileds = clazz.getDeclaredFields();
        Arrays.stream(decFileds).forEach(System.out::println);
    }

    /**
     * 权限修饰符 数据类型 变量名
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/16 20:57
     */
    @Test
    public void test03() {
        Class clazz = Person.class;
        //获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //权限修饰符
            int modi = field.getModifiers();
            System.out.println(modi);
            //数据类型
            Class type = field.getType();
            System.out.println(type);
            //变量名
            String name = field.getName();
            System.out.println(name);
        }
        System.out.println("*****************************");
    }

    /**
     * 获取运行时类的方法结构
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/16 21:02
     */
    @Test
    public void test04() {
        Class clazz = Person.class;

        // 获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("**********************");
        // 获取当前运行时类所有方法 不包括父类方法
        Method[] decMethods = clazz.getDeclaredMethods();
        for (Method method : decMethods) {
            Annotation[] annotations = method.getAnnotations();
            //获取方法声明的注解
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            //返回值类型
            System.out.print(method.getReturnType() + " ");
            //方法名
            System.out.print(method.getName() + " ");
            //形参
            System.out.print("(");
            Class[] parameterTypes = method.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0)) {
                System.out.print("args ");
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName());
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + ",");
                }
            }
            System.out.print(") ");
            //抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if(!(exceptionTypes == null || exceptionTypes.length == 0)) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
                System.out.print(exceptionTypes[exceptionTypes.length - 1].getName() + ",");
            }
            System.out.println();
            System.out.println(method);
            System.out.println();
        }
    }

    /**
     * description: 获取构造器结构
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/16 23:17
     */
    @Test
    public void test05() {
        Class clazz = Person.class;
        // 获取当前运行时类声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("*******************************");

        // 获取当前运行时类声明所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
        System.out.println("*******************************");
    }
    
    /**
     * description: 获取运行时类的父类及父类的泛型
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/16 23:21
     */
    @Test
    public void test06() {
        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        Type genericSuperclass = clazz.getGenericSuperclass();

        System.out.println(superClass);
        System.out.println(genericSuperclass);
    }

    /**
     * description: 获取运行时类实现的接口
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:07
     */
    @Test
    public void test07() {
        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        Class[] interfaces = clazz.getInterfaces();
        Class[] interfaces1 = superClass.getInterfaces();

        Type[] genericInterfaces = clazz.getGenericInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);
        System.out.println();
        Arrays.stream(interfaces1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(genericInterfaces).forEach(System.out::println);
    }

    /**
     * description: 获取运行时类所在的包
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:16
     */
    @Test
    public void test08() {
        Class clazz = Person.class;
        Package pkg = clazz.getPackage();

        System.out.println(pkg);
    }

    /**
     * description: 获取运行时类声明的注解
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:16
     */
    @Test
    public void test09() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
    }

    /**
     * description: 调用运行时类指定的结构：属性
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:21
     */
    @Test
    public void test10() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();
        //获取父类及本类public的属性
        Field[] fields = clazz.getFields();
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println();
        //获取本类的所有属性
        Field[] decFileds = clazz.getDeclaredFields();
        Arrays.stream(decFileds).forEach(System.out::println);
        System.out.println();
        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        id.set(person, 1001);

        int pId = (int) id.get(person);
        System.out.println(pId);

    }

    /**
     * description: 调用运行时类指定的结构：方法
     * 较为重要
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:21
     */
    @Test
    public void test11() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);
        System.out.println();
        Person person = (Person) clazz.newInstance();
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(person, "China");
        System.out.println();

        Method showPreMess = clazz.getDeclaredMethod("showPreMess");
        Object invoke = showPreMess.invoke(person);
        System.out.println(invoke);
    }

    /**
     * description: 调用运行时类指定的结构：构造器
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/17 23:21
     */
    @Test
    public void test12() {

    }
}
