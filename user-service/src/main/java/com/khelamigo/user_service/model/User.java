package com.khelamigo.user_service.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Profile Information
    private String username;
    private String name;
    private String bio;
    private String gender;
    private Date dob;
    private String address;
    private Double latitude;
    private Double longitude;

    //Contact

    private String email;
    private Long phone;

    //Social
    private String facebook;
    private String twitter;
    private String instagram;
    private String linkedin;

    //Security & Account Management

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "phone_verified")
    private Boolean phoneVerified;

    @Column(name = "password_updated_at")
    private Date passwordUpdatedAt;

    @Column(name = "login_attempts")
    private Integer loginAttempts;
    private Boolean locked; 

    @Column(name = "locked_reason")
    private String lockedReason; //Reason for locking account

    private Boolean active;// Deactivating account

    private Boolean online;

    @Column(name = "last_seen")
    private Date lastSeen;

    //Notifications
    private Boolean notificationsEnabled;
    private Boolean emailNotifications;
    private Boolean smsNotifications;
    private Boolean appNotifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSports> userSports;

}
