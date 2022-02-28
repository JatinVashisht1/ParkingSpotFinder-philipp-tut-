package com.example.parkingspotfinder.data

import com.example.parkingspotfinder.domain.ParkingSpotRepo
import com.example.parkingspotfinder.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRepoImpl(
    private val dao: ParkingSpotDao
) : ParkingSpotRepo {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot = spot.toParkingSpot())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteParkingSpot(spot = spot.toParkingSpot())
    }

    override suspend fun getAllParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map { spotList ->
            spotList.map { spot ->
                spot.toParkingSpot()
            }
        }
    }
}