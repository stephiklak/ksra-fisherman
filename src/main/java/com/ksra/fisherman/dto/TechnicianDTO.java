package com.ksra.fisherman.dto;

import com.ksra.fisherman.model.Technician;
import lombok.Data;

@Data
public class TechnicianDTO {
    private Long id;
    private Long userId;
    private String skills;
    private Integer experienceYears;
    private Double rating;
    private String availabilityStatus;
}
