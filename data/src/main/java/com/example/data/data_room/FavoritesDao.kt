package com.example.data.data_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItemFavorites(item: VacancyEntity)

    @Delete()
    suspend fun deleteItemFavorites(item: VacancyEntity)

    @Query("SELECT * FROm vacancy")
    fun getAllItemsFavorites(): Flow<List<VacancyEntity>>

}