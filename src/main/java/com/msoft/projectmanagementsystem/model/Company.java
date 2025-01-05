package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created On : 2025 02 Jan 5:28 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SuperAdmin.class)
    @JoinColumn(name = "super_admin_id", foreignKey = @ForeignKey(name = "fk_company_id"))
    private SuperAdmin superAdmin;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Client> clients;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getCompanyActive() {
        return isCompanyActive;
    }

    public void setCompanyActive(Boolean companyActive) {
        isCompanyActive = companyActive;
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

    public Company() {
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Company(long companyId, String companyName, String email, String companyPassword, String phone, String address, String city, String state, Boolean isCompanyActive, LocalDateTime createdAt, LocalDateTime updatedAt, SuperAdmin superAdmin) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.email = email;
        this.companyPassword = companyPassword;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.isCompanyActive = isCompanyActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.superAdmin = superAdmin;
    }
}
