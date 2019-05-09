package com.base.java8.samples.lambda;

/**
 * @author liaowenbo
 */
public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        //@FunctionalInterface 只要接口只包含一个抽象方法，虚拟机会自动判断该接口为函数式接口
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123


        // method reference 方法和构造函数引用
        //代码还可以通过静态方法引用来表示
        //::关键字传递方法或构造函数的引用。 上面的示例显示了如何引用静态方法。 但我们也可以引用对象方法：
        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123

        //引用对象方法
        Something something = new Something();
        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J

        // constructor reference
        //构造函数引用来将他们关联起来，而不是手动实现一个完整的工厂
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
