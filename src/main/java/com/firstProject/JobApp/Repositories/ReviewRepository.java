package com.firstProject.JobApp.Repositories;

import com.firstProject.JobApp.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findCompanyById(Long companyId);
}
