package com.sridhar.bottle.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @NotBlank(message = "title shouldn't be blank")
    public String title;
    @NotBlank(message = "author shouldn't be blank")
    public String author;

    @Enumerated(value = EnumType.STRING)
    public Genre genre;
    public Double cost;

    @Min(value = 1000,message = "rating should be minimum of 1000")
    public Integer year;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Review> reviews;
}
