package com.msoft.projectmanagementsystem.model;

import com.msoft.projectmanagementsystem.enums.Duration;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created On:1/3/25 1:02 PM
 * Author: Sumit Kumar Shrestha
 * Description:
 **/
@Entity
@Table(name = "subscription_plan")
@Data
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionPlanId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "employee_limit", nullable = false)
    private Integer employeeLimit;

    @Column(name = "project_limit", nullable = false)
    private Integer projectLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration", nullable = false)
    private Duration duration;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_active")
    private Boolean isActive = true;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

