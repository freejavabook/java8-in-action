package me.freelife.chap03;

/**
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class Lambda {
    public static void main(String[] args) {

        /* 람다 사용 */
        Runnable r1 = () -> System.out.println("Hello World 1");

        /* 익명 클래스 사용 */
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        process(r1); //Hello World 1 출력
        process(r2); //Hello World 2 출력
        process(() -> System.out.println("Hello World 3")); //직접 전달된 람다 표현식으로 Hello World 3 출력
    }

    /**
     * Runnable 실행함수
     * @param r
     */
    private static void process(Runnable r){
        r.run();
    }
}
