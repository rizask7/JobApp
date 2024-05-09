package com.firstProject.JobApp.Repositories;

import com.firstProject.JobApp.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
