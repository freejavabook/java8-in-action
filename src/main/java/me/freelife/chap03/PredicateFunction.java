package me.freelife.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class PredicateFunction {

    public static void main(String[] args) {

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.addAll(Arrays.asList("1","2","3","4"));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);

        /**
         *  Predicate 조합
         **/
        Predicate<Apple> redApple = a -> a.getColor().equals("red");
        // 기존 프레디케이트 객체 redApple의 결과를 반전시킨 객체를 만든다
        Predicate<Apple> notRedApple = redApple.negate();

        /* 두 프레디케이트를 연결해서 새로운 프레디케이트 객체를 만든다 */
        // and 메서드를 이용해서 빨간색이면서 무거운 사과를 선택하도록 두 람다를 조합할 수 있다
        Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);

        /* 프레디케이트 메서드를 연결해서 더 복잡한 프레디케이트 객체를 만든다 */
        // or를 이용해서 '빨간색이면서 무거운(150그램이상) 또는 그냥 녹색 사과'등 다양한 조건을 만들 수 있다
        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(a -> a.getWeight() > 150)
                        .or(a -> "green".equals(a.getColor()));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list) {
            if(p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

}
