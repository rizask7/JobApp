package com.firstProject.JobApp.Controllers;

import com.firstProject.JobApp.Entities.Job;
import com.firstProject.JobApp.ServiceLayer.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job)
    {
        try
        {
            jobService.createJob(job);
            return new ResponseEntity<>(job, HttpStatus.CREATED);
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job)
    {
        try
        {
            Optional<Job> updatedJob = jobService.updateJob(id, job);
            return updatedJob.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs()
    {
        List<Job> jobs = jobService.getAllJobs();
        if(!jobs.isEmpty())
        {
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id)
    {
        if(jobService.deleteJobById(id))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
