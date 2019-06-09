package me.freelife.chap03;

import lombok.*;

/**
 * Created by freejava1191@gmail.com on 2019-06-03
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Apple extends Fruit{
    private Integer weight = 0;
    private String color = "";
    private String country = "";

    public Apple(Integer weight) {
        this.weight = weight;
    }


    public Apple(String color, Integer integer) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
