package com.example.searchjob.view.favorites_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.favorites.FavoritesUseCases
import com.example.domain.usecases.getformat.GetFormatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesVM @Inject constructor(
    private val favoritesUseCases: FavoritesUseCases,
    //private val getFormatUseCases: GetFormatUseCases
) : ViewModel(){

    val listFavorites = favoritesUseCases.getAllFavorites.invoke()

    fun getLookingText(number: Int): String {
     //   return getFormatUseCases.getFormatLookingTextUS.invoke(number)
        return ""
    }

    fun getVacanciesText(number: Int): String {
       // return getFormatUseCases.getFormatVacanciesTextUS.invoke(number)
        return ""
    }
}