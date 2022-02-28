package com.example.parkingspotfinder.domain.model

data class ParkingSpot(
    val lat: Double,
    val lon: Double,
    val id: Int? = null
)
