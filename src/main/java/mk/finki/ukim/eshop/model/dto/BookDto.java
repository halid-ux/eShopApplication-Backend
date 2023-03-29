package mk.finki.ukim.eshop.model.dto;

import lombok.Data;
import mk.finki.ukim.eshop.model.enums.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;
}
