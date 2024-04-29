package com.example.jobapprest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobapprest.model.JobPost;
import com.example.jobapprest.repo.JobRepo;

@Service
public class JobService {
    
    @Autowired
    public JobRepo jobRepo;

    public JobPost addJobPost(JobPost jobPost) {
        jobRepo.addJobPost(jobPost);
        return jobRepo.getJob(jobPost.getPostId());
    }

    public List<JobPost> getAllJobPosts() {
        return jobRepo.getAllJobPosts();
    }

    public JobPost getJobPost(int postId) {
        return jobRepo.getJob(postId);
    }

    public JobPost updateJobPost(int postId, JobPost updatedJobPost) {
        jobRepo.updateJobPost(postId, updatedJobPost);
        return jobRepo.getJob(postId);
    }

    public void deleteJobPost(int postId) {
        jobRepo.deleteJobPost(postId);
    }
}
