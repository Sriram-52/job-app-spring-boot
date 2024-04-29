package com.example.jobapprest.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jobapprest.model.JobPost;

@Repository
public class JobRepo {
    List<JobPost> jobPosts = new ArrayList<>(
        Arrays.asList(
            new JobPost(1, "Java Developer", "Java Developer with 5 years of experience", 5, Arrays.asList("Java", "Spring Boot", "Hibernate")),
            new JobPost(2, "Python Developer", "Python Developer with 3 years of experience", 3, Arrays.asList("Python", "Django", "Flask")),
            new JobPost(3, "React Developer", "React Developer with 2 years of experience", 2, Arrays.asList("React", "Redux", "JavaScript"))
        )
    );

    public List<JobPost> getAllJobPosts() {
        return jobPosts;
    }

    public void addJobPost(JobPost jobPost) {
        jobPosts.add(jobPost);
        System.out.println(jobPosts);
    }

    public JobPost getJob(int postId) {
        for (JobPost jobPost: jobPosts) {
            if (jobPost.getPostId() == postId) {
                return jobPost;
            }
        }
        return null;
    }

    public JobPost updateJobPost(int postId, JobPost updatedJobPost) {
        for (JobPost jobPost: jobPosts) {
            if (jobPost.getPostId() == postId) {
                jobPost.setPostDesc(updatedJobPost.getPostDesc());
                jobPost.setPostProfile(updatedJobPost.getPostProfile());
                jobPost.setPostTechStack(updatedJobPost.getPostTechStack());
                jobPost.setReqExperience(updatedJobPost.getReqExperience());
                return jobPost;
            }
        }
        return null; 
    }

    public void deleteJobPost(int postId) {
        for (JobPost jobPost: jobPosts) {
            if (jobPost.getPostId() == postId) {
                jobPosts.remove(jobPost);
            }
        }
    }
}
