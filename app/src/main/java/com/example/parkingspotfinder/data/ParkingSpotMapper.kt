package com.example.parkingspotfinder.data

import com.example.parkingspotfinder.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot{
    return ParkingSpot(
        lat = lat,
        lon = lon,
        id = id
    )
}

fun ParkingSpot.toParkingSpot(): ParkingSpotEntity{
    return ParkingSpotEntity(
        lat = lat,
        lon = lon,
        id = id
    )
}