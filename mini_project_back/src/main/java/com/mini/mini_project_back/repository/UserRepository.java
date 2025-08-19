package com.mini.mini_project_back.repository;

import com.mini.mini_project_back.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByProviderAndProviderId(String provider, String providerId);
}
