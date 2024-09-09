package com.example.di

import android.app.Application
import androidx.room.Room
import com.example.data.data_room.FavoritesDb
import com.example.data.repository.FavoritesRepositoryImpl
import com.example.data.repository.RemoteRepositoryImpl
import com.example.domain.repository.FavoritesRepository
import com.example.domain.repository.RemoteRepository
import com.example.domain.usecases.GetRemoteDate
import com.example.domain.usecases.favorites.AddVacancyFavoritesUS
import com.example.domain.usecases.favorites.DeleteVacancyFavoritesUS
import com.example.domain.usecases.favorites.FavoritesUseCases
import com.example.domain.usecases.favorites.GetAllFavoritesUS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFavoritesDb(app: Application): FavoritesDb {
        return Room.databaseBuilder(
            app,
            FavoritesDb::class.java,
            "favorite"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoritesRepository(favoritesDb: FavoritesDb): FavoritesRepository {
        return FavoritesRepositoryImpl(favoritesDb.getFavoritesDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: FavoritesRepository): FavoritesUseCases {
        return FavoritesUseCases(
            addVacancy = AddVacancyFavoritesUS(repository),
            deleteVacancy = DeleteVacancyFavoritesUS(repository),
            getAllFavorites = GetAllFavoritesUS(repository)
        )

    }

    @Provides
    @Singleton
    fun provideRemoteRepository(app: Application): RemoteRepository {
        return RemoteRepositoryImpl(app.assets)
    }

    @Provides
    @Singleton
    fun provideGetRemoteUseCases(repository: RemoteRepository): GetRemoteDate{
        return GetRemoteDate(repository)
    }


}