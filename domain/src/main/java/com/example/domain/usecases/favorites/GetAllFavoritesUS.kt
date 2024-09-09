package com.example.domain.usecases.favorites

import com.example.domain.model.Vacancy
import com.example.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class GetAllFavoritesUS (
    private val repository: FavoritesRepository
) {
    fun invoke(): Flow<List<Vacancy>> {
       return repository.getAllFavorites()
    }
}