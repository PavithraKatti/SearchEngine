package com.example.jobsearchengine.Model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class JobSearchAddress {
        private String unit;
        private float maxJobDistance;
        private String longitude;
        private String latitude;
}
