package me.freelife.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 동작 파라미터화 코드 전달하기
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class FilteringApplesMain {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        /* 첫 번째 시도: 녹색 사과 필터링 */
        // [Apple(weight=80, color=green), Apple(weight=155, color=green)]
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println("---------------------------------------");
        System.out.println("첫 번째 시도: 녹색 사과 필터링");
        System.out.println(greenApples);

        /* 두 번째 시도: 색을 파라미터화 */
        // [Apple(weight=80, color=green), Apple(weight=155, color=green)]
        greenApples = filterApplesByColor(inventory, "green");
        System.out.println("---------------------------------------");
        System.out.println("두 번째 시도: 색을 파라미터화");
        System.out.println(greenApples);

        // [Apple(weight=120, color=red)]
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

        /* 세 번째 시도: 가능한 모든 속성으로 필터링 */
        greenApples = filterApples(inventory, "green", 0, true);
        List<Apple> heavyApples = filterApples(inventory, "", 150, false);

        /* 네 번째 시도: 추상적 조건으로 필터링 */
        // [Apple(weight=155, color=green)]
        heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        System.out.println("---------------------------------------");
        System.out.println("네 번째 시도: 추상적 조건으로 필터링");
        System.out.println(heavyApples);
        // [Apple(weight=80, color=green), Apple(weight=155, color=green)]
        greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples);

        /* 다섯 번째 시도: 익명 클래스 사용 */
        // [Apple(weight=120, color=red)]
        redApples = filterApples(inventory, new ApplePredicate() { //filterApples 메서드의 동작을 직접 파라미터화 함
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println("---------------------------------------");
        System.out.println("다섯 번째 시도: 익명 클래스 사용");
        System.out.println(redApples);

        /* 여섯 번째 시도: 람다 표현식 사용 */
        // [Apple(weight=120, color=red)]
        redApples = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println("---------------------------------------");
        System.out.println("여섯 번째 시도: 람다 표현식 사용");
        System.out.println(redApples);

        /* 일곱 번째 시도: 리스트 형식으로 추상화 */
        // [Apple(weight=120, color=red)]
        redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println("---------------------------------------");
        System.out.println("일곱 번째 시도: 리스트 형식으로 추상화");
        System.out.println(redApples);

        /* Comparator로 정렬하기 */
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("---------------------------------------");
        System.out.println("Comparator로 정렬하기");
        System.out.println(inventory);

        /* Comparator로 정렬하기 - 람다표현식으로 */
        inventory.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));

        /* Runnable로 코드 블록 실행하기 */
        System.out.println("---------------------------------------");
        System.out.println("Runnable로 코드 블록 실행하기");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
        t.run();

        /* Runnable로 코드 블록 실행하기 - 람다표현식으로 */
        t = new Thread(() -> System.out.println("Hello world"));
        t.run();
    }


    /**
     * 첫 번째 시도: 녹색 사과 필터링
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 두 번째 시도: 색을 파라미터화
     * @param inventory
     * @param color
     * @return
     */
    private static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 무게를 파라미터화
     * @param inventory
     * @param weight
     * @return
     */
    private static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 세 번째 시도: 가능한 모든 속성으로 필터링
     * 가장 안좋은 방법
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    private static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 네 번째 시도: 추상적 조건으로 필터링
     * @param inventory
     * @param p
     * @return
     */
    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory) {
            if(p.test(apple)){ //프레디케이트 객체로 사과 검사 조건을 캡슐화
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 일곱 번째 시도: 리스트 형식으로 추상화
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e: list) {
            if(p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

}
