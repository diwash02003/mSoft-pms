package com.msoft.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Created On : 2025 03 Jan 12:44 PM
 * Author : Monu Siddiki
 * Description :
 **/
@Data
@Entity
@Table(name = "company_subscription")
public class CompanySubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companySubscriptionId;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "subscription_id", nullable = false)
    private Long subscriptionId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", insertable = false, updatable = false)
    private SubscriptionPlan subscriptionPlan;
}

