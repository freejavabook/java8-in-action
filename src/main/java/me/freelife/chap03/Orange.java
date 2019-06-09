package me.freelife.chap03;

import lombok.*;

/**
 * Created by freejava1191@gmail.com on 2019-06-09
 * Blog : https://freedeveloper.tistory.com/
 * GitHub : https://github.com/freelife1191
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Orange extends Fruit {
    private Integer weight = 0;
    private String color = "";
    private String country = "";

    public Orange(Integer weight) {
        this.weight = weight;
    }

    public Orange(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
