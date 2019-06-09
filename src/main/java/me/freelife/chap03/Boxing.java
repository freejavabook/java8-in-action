package me.freelife.chap03;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * 박싱(boxing): 기본형을 참조형으로 변환할 수 있는 기능
 * 언박싱(unboxing): 참조형을 기본형으로 변환하는 반대 동작
 * 오토박싱(autoboxing): 프로그래머가 편리하게 코드를 구현할 수 있도록 박싱과 언박싱이 자동으로 이루어지는 것
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class Boxing {
    public static void main(String[] args) {
        // true (박싱 없음) - 기본형을 기본형으로 처리하므로 박싱 없음
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(1000));

        // false (박싱) - 기본형을 참조형으로 변환 하므로 박싱
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println(oddNumbers.test(1000));

    }

}
