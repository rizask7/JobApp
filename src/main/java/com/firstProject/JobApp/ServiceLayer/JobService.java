package com.firstProject.JobApp.ServiceLayer;

import com.firstProject.JobApp.Entities.Job;
import com.firstProject.JobApp.IServiceLayer.IJobService;
import com.firstProject.JobApp.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobService implements IJobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs(){

        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        if(jobRepository.existsById(id))
        {
        return jobRepository.findById(id);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void createJob(Job job) {
        Objects.requireNonNull(job, "Job cannot be Null");
        jobRepository.save(job);
    }

    @Override
    public boolean deleteJobById(Long id)
    {
        try{

            jobRepository.deleteById(id);
            return true;
    }
        catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Optional<Job> updateJob(Long id, Job job)
    {
        return jobRepository.findById(id).map(existingjob -> {
            existingjob.setTitle(job.getTitle());
            existingjob.setDescription(job.getDescription());
            existingjob.setLocation(job.getLocation());
            existingjob.setMaxSalary(job.getMaxSalary());
            existingjob.setMinSalary(job.getMinSalary());

            Job updatedJob = jobRepository.save(existingjob);
            return Optional.of(updatedJob);
        }).orElseGet(Optional :: empty);
    }

}
