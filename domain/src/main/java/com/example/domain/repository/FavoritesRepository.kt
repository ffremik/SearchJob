package com.example.domain.repository

import com.example.domain.model.Vacancy
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    suspend fun addVacancyFavorites(vacancy: Vacancy)

    suspend fun deleteVacancyFavorites(vacancy: Vacancy)

    fun getAllFavorites(): Flow<List<Vacancy>>

}