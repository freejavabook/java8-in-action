package me.freelife.chap03;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class ConstructorReference {
    public static void main(String[] args) {
        //디폴트 생성자 Apple()의 생성자 레퍼런스
        // Supplier<Apple> c1 = () -> new Apple();
        Supplier<Apple> c1 = Apple::new;
        //Supplier의 get 메서드를 호출해서 새로운 Apple 객체를 만들 수 있다
        Apple a1 = c1.get();
        System.out.println(a1);

        //Apple(Integer weight)의 생성자 레퍼런스
        // Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        Function<Integer, Apple> c2 = Apple::new;
        // Function의 apply 메서드를 무게를 인수로 호출해서 새로운 apply 객체로 만들 수 있다
        Apple a2 = c2.apply(110);
        System.out.println(a2);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        // map 메서드로 생성자 레퍼런스 전달
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples);

        /**
         * Apple(String color, Integer weight) 처럼 두 인수를 갖는 생성자는 BiFunction 인터페이스와 같은 시그너처를 가짐
         */
        // BiFunction<String, Integer, Apple> c3 = (color, weight) -> new Apple(weight, color); //특정 색과 무게를 가진 사과를 만드는 람다 표현식
        // Apple(String color, Integer weight)의 생성자 레퍼런스
        BiFunction<String, Integer, Apple> c3 = Apple::new;
        // BiFunction의 apply 메서드에 색과 무게를 인수로 제공해서 새로운 Apple 객체를 만들 수 있다
        Apple a3 = c3.apply("green", 110);


        System.out.println(giveMeFruit("apple", 110));
        System.out.println(giveMeFruit("orange", 110));

    }

    private static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e: list) {
            result.add(f.apply(e));
        }
        return result;
    }

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    /**
     * 다양한 무게를 갖는 여러 종류의 과일을 만드는 메서드
     * @param fruit
     * @param weight
     * @return
     */
    private static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase()) //map에서 Function<Integer, Fruit>를 얻었다
                .apply(weight); //Function의 apply 메서드에 정수 무게 파라미터를 제공해서 Fruit를 만들 수 있다
    }


}
