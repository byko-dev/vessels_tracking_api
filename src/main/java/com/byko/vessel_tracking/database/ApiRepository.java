package com.byko.vessel_tracking.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiRepository extends JpaRepository<ApiCredentials, Long> {
    List<ApiCredentials> findAll();
    ApiCredentials findById(long Id);
}
