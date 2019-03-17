package com.example.jobsearchengine.Controller;

import com.example.jobsearchengine.Model.Job;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobSearchControllerTest {

    private JobSearchController jobSearchControllerUnderTest;

    @Before
    public void setUp() {
        jobSearchControllerUnderTest = new JobSearchController();
    }

    @Test
    public void testGetMatchingJobs() {
        // Setup
        final int workerId = 3;

        // Run the test
        final List<Job> result = jobSearchControllerUnderTest.getMatchingJobs(workerId);

        // Verify the results
        assertTrue(result.size() > 0);
    }
}
