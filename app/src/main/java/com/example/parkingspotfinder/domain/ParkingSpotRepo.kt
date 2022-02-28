package com.example.parkingspotfinder.domain

import com.example.parkingspotfinder.data.ParkingSpotEntity
import com.example.parkingspotfinder.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepo {
    suspend fun insertParkingSpot(spot: ParkingSpot)
    suspend fun deleteParkingSpot(spot: ParkingSpot)
    suspend fun getAllParkingSpots() : Flow<List<ParkingSpot>>
}