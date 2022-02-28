package com.example.parkingspotfinder.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parkingspotfinder.data.ParkingSpotDatabase
import com.example.parkingspotfinder.data.ParkingSpotRepoImpl
import com.example.parkingspotfinder.domain.ParkingSpotRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDatabase{
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spot_db"
        ).build()
    }
    @Singleton
    @Provides
    fun provideParkingSpotRepo(db: ParkingSpotDatabase): ParkingSpotRepo = ParkingSpotRepoImpl(dao = db.dao)

}

