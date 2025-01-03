package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created On : 2025 03 Jan 12:54 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Data
@Table(name = "company_admin_permission")
@Entity
public class CompanyAdminPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private GlobalCompanyPermission globalCompanyPermission;
}
