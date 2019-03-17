package com.example.jobsearchengine.Controller;

import com.example.jobsearchengine.Model.Job;
import com.example.jobsearchengine.Service.JobWorkerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@RestController
public class JobSearchController {

    private JobWorkerService jobWorkerService = new JobWorkerService();

    @RequestMapping(method = RequestMethod.GET, value = "/jobs/{workerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Job> getMatchingJobs(@PathVariable int workerId)
    {
        List<Job> jobsMatched = null;
        try {
            jobsMatched = jobWorkerService.getJobsMatchedForWorker(workerId);
        }catch (Exception e){
            LOGGER.log(java.util.logging.Level.SEVERE, "Failed to search jobs for this worker id - "+workerId+" - "+e.getMessage());
        }
        return jobsMatched;
    }
}
