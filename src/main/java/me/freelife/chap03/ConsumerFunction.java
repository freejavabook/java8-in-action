package me.freelife.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class ConsumerFunction {
    public static void main(String[] args) {
        forEach(
            Arrays.asList(1, 2, 3, 4, 5),
            //Consumer의 accept 메서드를 구현하는 람다
            (Integer i) -> System.out.println(i)
        );
    }

    private static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T i: list) {
            c.accept(i);
        }
    }
}
