package com.firstProject.JobApp.Controllers;

import com.firstProject.JobApp.Entities.Review;
import com.firstProject.JobApp.ServiceLayer.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id)
    {

            List<Review> reviews = reviewService.getAllReviews(id);
            if(!reviews.isEmpty())
            {
                return new ResponseEntity<>(reviews, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

    }
}
