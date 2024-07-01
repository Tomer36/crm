package com.crmproject.crm.dto;

import java.time.LocalDateTime;

public class ActivityLogDTO {
    private Long id;
    private String description;
    private LocalDateTime timestamp;
    private Long customerId;
    private Long userId;
    private int treatmentNumber;
    private String therapist;

    // Constructors
    public ActivityLogDTO() {}

    public ActivityLogDTO(Long id, String description, LocalDateTime timestamp, Long customerId, Long userId, int treatmentNumber, String therapist) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.userId = userId;
        this.treatmentNumber = treatmentNumber;
        this.therapist = therapist;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(int treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }

    public String getTherapist() {
        return therapist;
    }

    public void setTherapist(String therapist) {
        this.therapist = therapist;
    }
}
