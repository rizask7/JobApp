package com.firstProject.JobApp.IServiceLayer;

import com.firstProject.JobApp.Entities.Review;

import java.util.List;

public interface IReviewService {

    List<Review> getAllReviews(Long companyId);

//    Review getReviewById(Long companyId, Long reviewId);


}
