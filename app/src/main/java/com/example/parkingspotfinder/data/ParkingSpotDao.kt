package com.example.parkingspotfinder.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingSpotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSpot(spot: ParkingSpotEntity)

    @Delete
    suspend fun deleteParkingSpot(spot: ParkingSpotEntity)

    // we have not made this function suspend because it returns flow
    // flows are already asynchronous
    @Query("SELECT * FROM parkingspotentity")
    fun getParkingSpots() : Flow<List<ParkingSpotEntity>>
}