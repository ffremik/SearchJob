package com.example.searchjob.view.mainscreen.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Offer
import com.example.domain.model.Vacancy
import com.example.domain.usecases.getformat.GetFormatLookingTextUS
import com.example.domain.usecases.GetRemoteDate
import com.example.domain.usecases.favorites.FavoritesUseCases
import com.example.domain.usecases.getformat.GetFormatUseCases
import com.example.searchjob.view.mainscreen.model.StateMainScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val favoritesUS: FavoritesUseCases,
    private val getRemoteDate: GetRemoteDate,
    private val getFormatUseCases: GetFormatUseCases,

    ) : ViewModel() {
    val uiStateMainScreen = MutableStateFlow<StateMainScreen>(StateMainScreen.Loading)
    val vacancies = MutableStateFlow(emptyList<Vacancy>())
    val offers = MutableStateFlow(emptyList<Offer>())
    val favoritesList = favoritesUS.getAllFavorites.invoke()

    var vacancy = MutableStateFlow<Vacancy?>(null)



    private val _isShowAllItems = MutableStateFlow(false)
    val isShowAllItems = _isShowAllItems.asStateFlow()

    fun updateIsShowAllItems() {
        _isShowAllItems.value = !_isShowAllItems.value
    }

    init {
        getRemote()
    }

    private fun getRemote() {
        viewModelScope.launch {
            val mockData = getRemoteDate.invoke()
            if (mockData != null) {
                vacancies.value = mockData.vacancies
                offers.value = mockData.offers
                uiStateMainScreen.value = StateMainScreen.Success(mockData)
            } else {
                uiStateMainScreen.value = StateMainScreen.Error
            }

        }
    }

    val progressLoadingTimer = MutableStateFlow(0.1f)
    fun updateTimerLoadingProgress() {
        viewModelScope.launch {
            while (progressLoadingTimer.value <= 1.0f && uiStateMainScreen.value == StateMainScreen.Loading) {
                progressLoadingTimer.value += 0.1f
                Log.i("MyLog", " Таймер")
                delay(500)
                if (progressLoadingTimer.value >= 1.0f) {
                    progressLoadingTimer.value = 0.0f
                }
            }
        }
    }

    fun getVacanciesText(number: Int): String {
        return getFormatUseCases.getFormatVacanciesTextUS.invoke(number)
        //return ""
    }

    fun getLookingText(number: Int): String {
        return getFormatUseCases.getFormatLookingTextUS.invoke(number)
        //return  ""
    }

    fun viewVacancy(itemVacancy: Vacancy) {
        vacancy.value = itemVacancy
    }

    fun updateIsFavorites(item: Vacancy) {
        viewModelScope.launch {
           // val updateItem = item.copy(isFavorite = !item.isFavorite)
            if (!item.isFavorite) {
                item.isFavorite = !item.isFavorite
                favoritesUS.addVacancy.invoke(item)
            } else {
                item.isFavorite = !item.isFavorite
                favoritesUS.deleteVacancy.invoke(item)
            }
//            vacancies.value = vacancies.value.map {
//                if (it.id == item.id) updateItem else it
//            }
        }
    }

}