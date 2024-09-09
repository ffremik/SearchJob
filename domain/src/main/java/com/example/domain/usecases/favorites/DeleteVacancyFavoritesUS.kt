package com.example.domain.usecases.favorites

import com.example.domain.model.Vacancy
import com.example.domain.repository.FavoritesRepository

class DeleteVacancyFavoritesUS(
    private val repository: FavoritesRepository
) {
    suspend fun invoke(vacancy: Vacancy){
        repository.deleteVacancyFavorites(vacancy)
    }
}