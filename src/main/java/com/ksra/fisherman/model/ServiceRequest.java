package com.ksra.fisherman.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    private String description;
    private Double latitude;
    private Double longitude;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ServiceRequest() {}

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public User getCustomer() { return customer; }
    public Technician getTechnician() { return technician; }
    public String getDescription() { return description; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setCustomer(User customer) { this.customer = customer; }
    public void setTechnician(Technician technician) { this.technician = technician; }
    public void setDescription(String description) { this.description = description; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
