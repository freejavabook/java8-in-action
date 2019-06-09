package me.freelife.chap02;

/**
 * 동작 파라미터화: 프레디케이트로 사과 필터링
 * 무거운 사과 필터링
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
