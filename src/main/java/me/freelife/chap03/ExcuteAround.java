package me.freelife.chap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 람다 활용: 실행 어라운드 패턴
 *
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
public class ExcuteAround {
    public static void main(String[] args) throws IOException {

        /* 하나의 행을 실행 */
        // String result = processFileLimited();
        // System.out.println(result);

        /* 1단계: 동작 파라미터화를 기억하라 */
        // 두행을 출력
        String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());

    }

    /**
     * IOException을 던질 수 있는 시그너처와 일치하는 함수형 인터페이스 생성
     * @return
     * @throws IOException
     */
    private static String processFileLimited() throws IOException {
        //try-with-resource 구문 사용
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/freelife/chap03/data.txt"))){
            return br.readLine();
        }
    }

    /**
     * 2단계: 함수형 인터페이스를 이용해서 동작 전달
     */
    private interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }

    /**
     * 3단계: 동작 실행
     * @param p
     * @return
     * @throws IOException
     */
    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/freelife/chap03/data.txt"))){
            return p.process(br);
        }
    }
}
