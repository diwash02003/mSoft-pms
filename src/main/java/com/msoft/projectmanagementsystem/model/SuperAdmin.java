package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created On : 2025 02 Jan 5:28 PM
 * Author : Diwash Pokhrel
 * Description: This entity represents the Super Admin of the project management system.
 * The Super Admin has unique credentials, manages multiple companies, and has a list of associated companies.
 **/
@Entity
@Data
@Table(name = "super_admin")
public class SuperAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_admin_id")
    private Long superAdminId;

    @Column(nullable = false, name = "super_admin_password")
    private String password;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "superAdmin", fetch = FetchType.EAGER)
    private List<Company> companyList;

    public Long getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(Long superAdminId) {
        this.superAdminId = superAdminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
