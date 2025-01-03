package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created On : 2025 02 Jan 5:28 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_email", nullable = false)
    private String email;

    @Column(name = "company_password", nullable = false)
    private String companyPassword;

    @Column(name = "company_phone", nullable = false)
    private String phone;

    @Column(name = "company_address", nullable = false)
    private String address;

    @Column(name = "company_city", nullable = false)
    private String city;

    @Column(name = "company_state", nullable = false)
    private String state;

    @Column(name = "is_company_active")
    private Boolean isCompanyActive = true;

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
