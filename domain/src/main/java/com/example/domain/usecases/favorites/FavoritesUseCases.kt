package com.example.domain.usecases.favorites

data class FavoritesUseCases(
    val addVacancy: AddVacancyFavoritesUS,
    val deleteVacancy: DeleteVacancyFavoritesUS,
    val getAllFavorites: GetAllFavoritesUS
)