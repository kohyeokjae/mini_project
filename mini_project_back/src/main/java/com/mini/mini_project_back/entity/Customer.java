package com.mini.mini_project_back.entity;

import com.mini.mini_project_back.entity.dateTime.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Customer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long userId;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String email;

    @Column(name = "customer_phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "role", nullable = false)
    private String role;
}
