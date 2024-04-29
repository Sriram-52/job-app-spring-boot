package com.example.jobapprest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobapprest.model.JobPost;
import com.example.jobapprest.service.JobService;

@RestController
public class JobRestController {

    @Autowired
    public JobService service;

    @PostMapping("job-post")
    public JobPost createJob(@RequestBody JobPost jobPost) {
        return service.addJobPost(jobPost);
    }

    @GetMapping("job-post")
    public List<JobPost> getAllJobs() {
        return service.getAllJobPosts();
    }

    @GetMapping("job-post/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJobPost(postId);
    }

    @PutMapping("job-post/{postId}")
    public JobPost updateJob(@PathVariable("postId") int postId, @RequestBody JobPost jobPost) {
        return service.updateJobPost(postId, jobPost);
    }

    @DeleteMapping("job-post/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJobPost(postId);
        return "Post Deleted successfully";
    }
}
