package com.sridhar.bottle.service.resource;


import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.domain.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookRequest {
    @NotBlank(message = "title shouldn't be blank")
    private String title;
    @NotBlank(message = "author shouldn't be blank")
    private String author;
    @NotBlank(message = "genre shouldn't be blank")
    private String genre;
    @Min(value = 0,message = "cost should be minimum of 0")
    private Double cost;
    @Min(value = 1000,message = "year should be minimum of 1000")
    @NotNull
    private Integer year;

    public Book getBook(){
        Book book;
        book = Book.builder().title(this.title).author(this.author).genre(Genre.valueOf(this.genre)).cost(this.cost).year(this.year).build();
        return book;
    }
}
