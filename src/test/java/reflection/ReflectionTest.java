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
        // public boolean tech.snnukf.java8study.pojo.Person.equals(java.lang.Object)
        // public java.lang.String tech.snnukf.java8study.pojo.Person.toString()
        // public int tech.snnukf.java8study.pojo.Person.hashCode()
        // public java.lang.String tech.snnukf.java8study.pojo.Person.getName()
        // public void tech.snnukf.java8study.pojo.Person.setName(java.lang.String)
        // public void tech.snnukf.java8study.pojo.Person.show()
        // public java.lang.String tech.snnukf.java8study.pojo.Person.getNickName()
        // public int tech.snnukf.java8study.pojo.Person.getAge()
        // public void tech.snnukf.java8study.pojo.Person.setAge(int)
        // public void tech.snnukf.java8study.pojo.Person.setNickName(java.lang.String)
        // public void tech.snnukf.java8study.pojo.Feature.setSex(int)
        // public int tech.snnukf.java8study.pojo.Feature.getSex()
        // public int tech.snnukf.java8study.pojo.Feature.getWeight()
        // public void tech.snnukf.java8study.pojo.Feature.setWeight(int)
        // public final void java.lang.Object.wait() throws java.lang.InterruptedException
        // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        // public final native java.lang.Class java.lang.Object.getClass()
        // public final native void java.lang.Object.notify()
        // public final native void java.lang.Object.notifyAll()
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("**********************");
        // 获取当前运行时类所有方法 不包括父类方法
        // public boolean tech.snnukf.java8study.pojo.Person.equals(java.lang.Object)
        // public java.lang.String tech.snnukf.java8study.pojo.Person.toString()
        // public int tech.snnukf.java8study.pojo.Person.hashCode()
        // public java.lang.String tech.snnukf.java8study.pojo.Person.getName()
        // public void tech.snnukf.java8study.pojo.Person.setName(java.lang.String)
        // public void tech.snnukf.java8study.pojo.Person.show()
        // private void tech.snnukf.java8study.pojo.Person.showNation(java.lang.String)
        // protected boolean tech.snnukf.java8study.pojo.Person.canEqual(java.lang.Object)
        // public java.lang.String tech.snnukf.java8study.pojo.Person.getNickName()
        // public int tech.snnukf.java8study.pojo.Person.getAge()
        // public void tech.snnukf.java8study.pojo.Person.setAge(int)
        // public void tech.snnukf.java8study.pojo.Person.setNickName(java.lang.String)
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
                for (int i = 0; i < parameterTypes.length - 1; i++) {
                    if(i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName());
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + ",");
                }
                System.out.print(parameterTypes[parameterTypes.length - 1].getName() + ",");
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
        
    }
}
