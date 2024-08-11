package com.sridhar.bottle.service.resource;


import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private String comment;
    private Double rating;
    private Integer book_id;

    public Review getReview(){
        Review review;
        review = Review.builder().comment(this.comment).rating(this.rating)
                .book(Book.builder().id(this.book_id).build()).build();
        return review;

    }
}
