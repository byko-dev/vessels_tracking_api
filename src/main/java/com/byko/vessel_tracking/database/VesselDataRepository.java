package com.byko.vessel_tracking.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselDataRepository extends JpaRepository<VesselTrackingData, Long> {
    VesselTrackingData findByShipNameAndMmsi(String shipName, int mmsi);
}
