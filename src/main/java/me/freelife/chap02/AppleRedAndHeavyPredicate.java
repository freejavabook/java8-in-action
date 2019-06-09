package me.freelife.chap02;

/**
 * 빨간 사과이면서 무거운 사과만
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}