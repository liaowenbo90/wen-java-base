package com.base.java8.samples.builtInfunction;


import com.base.java8.samples.lambda.Lambda2;
import com.base.java8.samples.lambda.Person;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 内置函数
 */
public class Builttest {

    public static void main(String[] args) {
        //断言
        Predicate<Integer> predicate = (s) -> s > 0;
        System.out.println(predicate.test(2));
        //Function 传一个参数输出一个结果，可将多个函数连接起来 compose,andThen
        Function<Integer,String> function = (s) -> String.valueOf(s);
        Function<Integer, Object> after = function.andThen(String::valueOf);

        function.apply(123);

        // Optional 用于判断空指针异常

        String person = getPerson(new Person("aa","bb"));
        getPerson(new Person());
    }

    public static String getPerson(Person person) {
        return Optional.ofNullable(person)
                .map(a -> a.getFirstName()).orElseThrow(()-> new IllegalArgumentException("param is null"));


    }
}
