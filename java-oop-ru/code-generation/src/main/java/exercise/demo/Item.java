package exercise.demo;

import lombok.*;

@Builder
public class Item {
    @NonNull
    private Integer id;
    private String name;
    private Double price;
}
