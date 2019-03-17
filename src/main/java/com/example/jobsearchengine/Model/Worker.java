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
public class Worker {

    private float rating;
    private boolean isActive;
    List<String> certificates;
    List<String> skills;
    JobSearchAddress JobSearchAddressObject;
    private String transportation;
    private boolean hasDriversLicense;
    List<Object> availability;
    private String phone;
    private String email;
    Name NameObject;
    private float age;
    private String guid;
    private float userId;
}