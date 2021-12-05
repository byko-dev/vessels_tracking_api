package com.byko.vessel_tracking.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository extends JpaRepository<ApiCredentials, Long> {
    List<ApiCredentials> findAll();
}
