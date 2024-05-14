package com.firstProject.JobApp.Controllers;

import com.firstProject.JobApp.Entities.Review;
import com.firstProject.JobApp.ServiceLayer.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {

            List<Review> reviews = reviewService.getAllReviews(companyId);
            if(!reviews.isEmpty())
            {
                return new ResponseEntity<>(reviews, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

    }
    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review review, @PathVariable Long companyId)
    {
        try
        {
            boolean isReviewSaved = reviewService.addReview(review, companyId);
            if(isReviewSaved)
            {
                return new ResponseEntity<>(review,HttpStatus.CREATED);
            }
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(review, HttpStatus.NOT_FOUND);


    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        try
        {
            Optional<Review> review = reviewService.getReviewById(companyId, reviewId);
            return review.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                    .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId, @RequestBody Review review)
    {
        try
        {
            Optional<Review> updatedReview = reviewService.updateReview(companyId, reviewId, review);
            return updatedReview.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        try
        {
            if(reviewService.deleteReview(companyId,reviewId))
            {
                return ResponseEntity.ok("Review with ID "+reviewId+" deleted successfully");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Review with ID "+reviewId+" not found!");
            }
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
