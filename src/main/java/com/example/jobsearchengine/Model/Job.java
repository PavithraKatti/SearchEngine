package com.example.jobsearchengine.Model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class Job {

    private boolean driverLicenseRequired;
    List<String> requiredCertificates;
    Location location;
    private String billRate;
    private float workersRequired;
    private String startDate;
    private String about;
    private String jobTitle;
    private String company;
    private String guid;
    private float jobId;
}