package com.example.data.data_room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        VacancyEntity::class,
        AddressEntity::class,
        ExperienceEntity::class,
        SalaryEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class FavoritesDb() : RoomDatabase() {
    abstract fun getFavoritesDao(): FavoritesDao

}