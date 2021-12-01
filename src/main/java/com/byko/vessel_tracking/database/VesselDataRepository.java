package com.byko.vessel_tracking.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselDataRepository extends JpaRepository<VesselTrackingData, Long> {
}
