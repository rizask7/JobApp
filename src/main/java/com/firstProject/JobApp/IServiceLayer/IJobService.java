package com.firstProject.JobApp.IServiceLayer;

import com.firstProject.JobApp.Entities.Job;

import java.util.List;
import java.util.Optional;

public interface IJobService {
    List<Job> getAllJobs();

    Optional<Job> getJobById(Long id);

    void createJob(Job job);

    boolean deleteJobById(Long id);

    Optional<Job> updateJob(Long id, Job job);
}

