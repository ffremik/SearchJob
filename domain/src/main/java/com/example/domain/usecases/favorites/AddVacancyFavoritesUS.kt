package com.example.domain.usecases.favorites

import com.example.domain.model.Vacancy
import com.example.domain.repository.FavoritesRepository
import javax.inject.Inject

class AddVacancyFavoritesUS (
   private val repository: FavoritesRepository
) {
    suspend fun invoke(vacancy: Vacancy){
        repository.addVacancyFavorites(vacancy)
    }
}