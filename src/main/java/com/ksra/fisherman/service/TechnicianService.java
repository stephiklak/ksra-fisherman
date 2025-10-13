package com.ksra.fisherman.service;

import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getById(Long id) {
        return technicianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technician not found"));
    }

    public Technician createTechnician(User user, String skills, Integer experienceYears) {
        Technician technician = new Technician();
        technician.setUser(user);
        technician.setSkills(skills);
        technician.setExperienceYears(experienceYears);
        return technicianRepository.save(technician);
    }
}
