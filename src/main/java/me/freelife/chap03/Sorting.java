package me.freelife.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class Sorting {
    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80,"green", "korea"),
                new Apple(155, "green", "china"),
                new Apple(120, "red", "korea"),
                new Apple(10, "green", "china"),
                new Apple(30, "green", "china"),
                new Apple(80, "green", "Twian"),
                new Apple(80, "green", "Austrailia"),
                new Apple(155, "green", "japan")
            )
        );

        /* 사과 무게를 비교하여 오름차순 정렬 */
        // [Apple(weight=80, color=green), Apple(weight=120, color=red), Apple(weight=155, color=green)]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        /* index 1에 해당되는 값을 변경 */
        // [Apple(weight=80, color=green), Apple(weight=30, color=green), Apple(weight=155, color=green)]
        inventory.set(1, new Apple(30, "green", "korea"));
        System.out.println(inventory);

        /* 사과 무게를 비교하여 오름차순 정렬 - 람다 표현식 이용 */
        // [Apple(weight=30, color=green), Apple(weight=80, color=green), Apple(weight=155, color=green)]
        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        System.out.println(inventory);

        /* index 1에 해당되는 값을 변경 */
        // [Apple(weight=30, color=green), Apple(weight=10, color=red), Apple(weight=155, color=green)]
        inventory.set(1, new Apple(10, "red", "korea"));
        System.out.println(inventory);

        /* 사과를 무게를 비교하여 오름차순 정렬 - 람다 표현식 */
        inventory.sort(comparing((a) -> a.getWeight()));
        /* 사과 무게를 비교하여 오름차순 정렬 - 메서드 파라메터 이용 */
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
        /* 역정렬 */
        inventory.sort(comparing(Apple::getWeight)
                .reversed() // 무게를 내림차순으로 정렬
                .thenComparing(Apple::getCountry)); //Comparator 연결 두 사과의 무게가 같으면 국가별로 정렬
        System.out.println(inventory);

    }

    /**
     * 사과무게를 비교하여 오름차순 정렬
     */
    private static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
