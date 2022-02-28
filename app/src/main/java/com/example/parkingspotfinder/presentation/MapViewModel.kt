package com.example.parkingspotfinder.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkingspotfinder.domain.ParkingSpotRepo
import com.example.parkingspotfinder.domain.model.ParkingSpot
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repo: ParkingSpotRepo
) : ViewModel() {
    var state by mutableStateOf(MapState())

    init{
        viewModelScope.launch {
            repo.getAllParkingSpots().collectLatest {spots->
                state = state.copy(parkingSpots = spots)
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.ToggleFalloutMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions =
                        if (state.isFalloutMap) null else MapStyleOptions(MapStyle.json)
                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
            is MapEvent.OnInfoWindowLongClick -> {
                viewModelScope.launch {
                    repo.deleteParkingSpot(spot = event.spot)
                }
            }
            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    repo.insertParkingSpot(spot = ParkingSpot(event.latLon.latitude, event.latLon.longitude))
                }
            }
        }
    }
}
