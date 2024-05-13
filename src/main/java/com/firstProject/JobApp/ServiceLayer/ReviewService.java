package com.firstProject.JobApp.ServiceLayer;

import com.firstProject.JobApp.Entities.Company;
import com.firstProject.JobApp.Entities.Review;
import com.firstProject.JobApp.IServiceLayer.IReviewService;
import com.firstProject.JobApp.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CompanyService companyService;


    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findCompanyById(companyId);
    }

    @Override
    public boolean addReview(Review review, Long companyId)
    {
        Optional<Company> company = companyService.getCompanyById(companyId);
        if(company.isPresent())
        {
            Objects.requireNonNull(review,"Review cannot be Null");
            review.setCompany(company.get());
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Optional<Review> getReviewById(Long companyId, Long reviewId) {
        // Check if companyId and reviewId are not null
        if (companyId == null || reviewId == null) {
            throw new IllegalArgumentException("companyId and reviewId must not be null");
        }

        // Retrieve reviews for the given companyId
        List<Review> reviews = reviewRepository.findCompanyById(companyId);

        // Check if reviews are not null and not empty
        if (reviews == null || reviews.isEmpty()) {
            throw new RuntimeException("No reviews found for company with ID: " + companyId);
        }

        // Find the review with the specified reviewId
        Optional<Review> matchingReview = reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst();

        // Check if matchingReview is present
        if (matchingReview.isPresent()) {
            return matchingReview;
        } else {
            throw new RuntimeException("Review with ID " + reviewId + " not found for company with ID: " + companyId);
        }
    }

//    @Override
//    public Optional<Review> updateReview(Long companyId, Long reviewId, Review review) {
//        Company company = companyService.getCompanyById(companyId).get();
//    }

}
