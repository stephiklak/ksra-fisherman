package com.ksra.fisherman.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "technicians")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String skills;
    private Integer experienceYears;
    private Double rating;
    private Integer reviewCount;
    private String availabilityStatus;
    private Double latitude;
    private Double longitude;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Technician() {}

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public User getUser() { return user; }
    public String getSkills() { return skills; }
    public Integer getExperienceYears() { return experienceYears; }
    public Double getRating() { return rating; }
    public Integer getReviewCount() { return reviewCount; }
    public String getAvailabilityStatus() { return availabilityStatus; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUser(User user) { this.user = user; }
    public void setSkills(String skills) { this.skills = skills; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setReviewCount(Integer reviewCount) { this.reviewCount = reviewCount; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
