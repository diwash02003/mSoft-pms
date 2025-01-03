package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created On : 2025 03 Jan 12:51 PM
 * Author : Diwash Pokhrel
 * Description:
 **/
@Entity
@Data
@Table(name = "global_company_permission")
public class GlobalCompanyPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GlobalCompanyPermissionId;

    @Column(nullable = false)
    private String name;

    private String description;
}
