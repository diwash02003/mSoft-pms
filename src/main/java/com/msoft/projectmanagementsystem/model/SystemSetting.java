package com.msoft.projectmanagementsystem.model;

/**
 * Created On : 2025 03 Jan 12:54 PM
 * Author : Monu Siddiki
 * Description :
 **/

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "system_setting")
public class SystemSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemSettingId;

    @Column(name = "setting_key", unique = true, nullable = false, length = 100)
    private String settingKey;

    @Column(name = "setting_value", nullable = false, length = 255)
    private String settingValue;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
