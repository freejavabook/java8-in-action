package me.freelife.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * 메서드 레퍼런스
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class MethodReference {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        //람다 표현식
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(str);
        //메서드 레퍼런스 형식
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        //람다 표현식을 메서드 레퍼런스로 변경
        stringToInteger = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        //람다 표현식을 메서드 레퍼런스로 변경
        contains = List::contains;
    }
}
