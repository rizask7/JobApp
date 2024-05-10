package com.firstProject.JobApp.ServiceLayer;

import com.firstProject.JobApp.Entities.Review;
import com.firstProject.JobApp.IServiceLayer.IReviewService;
import com.firstProject.JobApp.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findCompanyById(companyId);
    }

//    @Override
//    public Review getReviewById(Long companyId, Long reviewId) {
//        return null;
//    }
}
