package me.freelife.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by freejava1191@gmail.com on 2019-06-03
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class FilteringApples {
    public static void main(String ...args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));

        /* 사과 색깔이 녹색인 것만 */
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        /* 150 보다 무거운 사과 */
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        /* 사과 색깔이 녹색인 것만 */
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        /* 사과 색깔이 브라운 색이거나 무게가 80 보다 작은 사과 */
        // []
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        System.out.println(heavyApples2);
    }

    /**
     * 녹색 사과이면 true 아니면 false
     * @param apple
     * @return
     */
    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    /**
     * 150 보다 무거우면 true 아니면 false
     * @param apple
     * @return
     */
    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * 메서드가 p라는 이름의 프레디케이트 파라미터로 전달됨
     * 프레디케이트란 인수로 값을 받아 true나 false를 반환하는 함수
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){ //사과는 p가 제시하는 조건에 맞는가?
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 녹색 사과 필터 메서드
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 150 보다 무거운 사과 필터 메서드
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
}
