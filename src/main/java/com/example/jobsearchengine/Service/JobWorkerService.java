package com.example.jobsearchengine.Service;

import com.example.jobsearchengine.Model.Job;
import com.example.jobsearchengine.Model.Worker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobWorkerService {

    private RestTemplate restTemplate =  new RestTemplate();

    private Gson gson = new GsonBuilder().create();

    private String JOBS_URL="http://test.swipejobs.com/api/jobs";

    private String WORKERS_URL="http://test.swipejobs.com/api/workers";

    private List<Job> getJobs(){
        String responseJobs = restTemplate.getForObject(JOBS_URL, String.class);
        return Arrays.asList(gson.fromJson(responseJobs, Job[].class));
    }

    private List<Worker> getWorkers(){
        String responseWorkers = restTemplate.getForObject(WORKERS_URL, String.class);
        return Arrays.asList(gson.fromJson(responseWorkers, Worker[].class));
    }



    public List<Job> getJobsMatchedForWorker(int workerId) {

        //Loading jobs and workers everytime since the json output might have changed with new jobs and workers.
        List<Job> jobs = getJobs();
        List<Worker> workers = getWorkers();

        List<Worker> workerFiltered = workers.stream().filter(x -> x.getUserId() == workerId).collect(Collectors.toList());

        List<Job> jobsMatched = jobs.stream().filter(
                job -> workerFiltered.stream().anyMatch(
                        worker -> CollectionUtils.containsAny(job.getRequiredCertificates(), worker.getCertificates()) &&
                                (job.isDriverLicenseRequired() ? worker.isHasDriversLicense() : true)
                )
        ).limit(3).collect(Collectors.toList());
        
        return jobsMatched;
    }
}
