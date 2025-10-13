package com.ksra.fisherman.service;

import com.ksra.fisherman.model.ServiceRequest;
import com.ksra.fisherman.model.Technician;
import com.ksra.fisherman.model.User;
import com.ksra.fisherman.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public List<ServiceRequest> getAllRequests() {
        return serviceRequestRepository.findAll();
    }

    public ServiceRequest getById(Long id) {
        return serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceRequest not found"));
    }

    public ServiceRequest createRequest(User customer, Technician technician, String description,
                                        Double lat, Double lng) {
        ServiceRequest req = new ServiceRequest();
        req.setCustomer(customer);
        req.setTechnician(technician);
        req.setDescription(description);
        req.setLatitude(lat);
        req.setLongitude(lng);
        return serviceRequestRepository.save(req);
    }
}
