package com.base.java8.samples.lambda;

import java.util.*;

/**
 * @author
 */
public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        /**
         * 只需要给静态方法Collections.sort 传入一个 List
         *   对象以及一个比较器来按指定顺序排列。
         *   通常做法都是创建一个匿名的比较器对象然后将其传递给 sort 方法。
         */
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        /**
         * 在Java 8 中你就没必要使用这种传统的匿名对象的方式了，
         * Java 8提供了更简洁的语法，lambda表达式：
         */
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println(names);

        names.sort(Collections.reverseOrder());

        System.out.println(names);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);
    }

}