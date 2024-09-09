package com.example.data.repository

import com.example.data.data_room.FavoritesDao
import com.example.data.mapper.toVacancy

import com.example.data.mapper.toEntity
import com.example.domain.model.Vacancy
import com.example.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoritesRepositoryImpl(private val favoritesDao: FavoritesDao):FavoritesRepository{

    override suspend fun addVacancyFavorites(vacancy: Vacancy) {
        favoritesDao.addItemFavorites(
            vacancy.toEntity()
        )
    }

    override suspend fun deleteVacancyFavorites(vacancy: Vacancy) {
        favoritesDao.deleteItemFavorites(vacancy.toEntity())
    }

    override fun getAllFavorites(): Flow<List<Vacancy>> {
        return favoritesDao.getAllItemsFavorites().map { list ->
            list.map {
                it.toVacancy()
            }
        }
    }

}