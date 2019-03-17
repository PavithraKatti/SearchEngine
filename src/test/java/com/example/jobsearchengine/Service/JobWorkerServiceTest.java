package com.example.jobsearchengine.Service;

import com.example.jobsearchengine.Model.Job;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobWorkerServiceTest {

    private JobWorkerService jobWorkerServiceUnderTest;

    @Before
    public void setUp() {
        jobWorkerServiceUnderTest = new JobWorkerService();
    }

    @Test
    public void testGetJobsMatchedForWorker() {
        // Setup
        final int workerId = 0;
        // Run the test
        final List<Job> result = jobWorkerServiceUnderTest.getJobsMatchedForWorker(workerId);

        // Verify the results
        assertTrue(result.size() > 0);
    }
}
