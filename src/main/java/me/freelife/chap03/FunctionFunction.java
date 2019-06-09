package me.freelife.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;

/**
 * Function
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class FunctionFunction {
    public static void main(String[] args) {

        // [7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                //Function의 apply 메서드를 구현하는 람다
                (String s) -> s.length()
        );
        System.out.println(l);

        /**
         * Function 조합
         */
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g); //수학으로는 write g(f(x)) 또는 (g o f)(x)라고 표현
        int result = h.apply(1); //4를 반환
        System.out.println(result);

        h = f.compose(g); //수학으로는 write f(g(x)) 또는 (f o g)(x)라고 표현
        result = h.apply(1); //3를 반환
        System.out.println(result);

        /**
         * 여러 유틸리티 메서드를 조합해서 다양한 변환 파이프라인을 만들 수 있다
         * 헤더를 추가(addHeader)한 다음에, 철자 검사(checkSpelling)를 하고,
         * 마지막에 푸터를 추가(addFooter)할 수 있다
         */
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transFormationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                         .andThen(Letter::addFooter);
        System.out.println(transFormationPipeline.apply("a"));

        /**
         * 철자 검사는 빼고 헤더와 푸터만 추가하는 파이프라인도 만들 수 있다
         */
        transFormationPipeline = addHeader.andThen(Letter::addFooter);
        System.out.println(transFormationPipeline.apply("b"));

        /**
         * 적분 자바 8 람다로 연결
         */
        System.out.println(integrate((double x) -> x + 10, 3, 7));

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }

    /**
     * 적분 자바 8 람다로 연결
     * 자바 코드를 수학 함수 처럼 구현할 수 없다
     * @param f
     * @param a
     * @param b
     * @return
     */
    private static double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
    }
}
