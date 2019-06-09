package me.freelife.chap02;

/**
 * 녹색 사과만 선택
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}