package com.firstProject.JobApp.IServiceLayer;

import com.firstProject.JobApp.Entities.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Review review , Long companyId);

    Optional<Review> getReviewById(Long companyId, Long reviewId);

    Optional<Review> updateReview(Long companyId, Long reviewId, Review updatedReview);

    boolean deleteReview(Long companyId, Long reviewId);


}
