package com.backend.technical.repos;

import com.backend.technical.modals.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findById(long jobId);
    List<Job> findAllByJobTitle(String jobTitle);
    List<Job> findAllBySalary(int salary);
}
