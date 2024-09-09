package com.example.searchjob.view.jobs_page_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Vacancy
import com.example.domain.usecases.GetRemoteDate
import com.example.domain.usecases.favorites.FavoritesUseCases
import com.example.domain.usecases.getformat.GetFormatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsPageVM @Inject constructor(
    private val getFormatUseCases: GetFormatUseCases,
    private val getRemoteDate: GetRemoteDate,
    private val favoritesUS: FavoritesUseCases,

) : ViewModel() {
    val isOpenReply = MutableStateFlow(false)
    val isOpenAddContent = MutableStateFlow(false)


    fun getFormatLookingText(number: Int): String {
        return getFormatUseCases.getFormatLookingTextUS.invoke(number)
      //  return ""
    }

    fun updateIsFavorites(item: Vacancy) {
        viewModelScope.launch {
            val updateItem = item.copy(isFavorite = !item.isFavorite)
            if (item.isFavorite) {
                favoritesUS.addVacancy.invoke(updateItem)
            } else {
                favoritesUS.deleteVacancy.invoke(updateItem)
            }
        }
    }

    fun updateIsOpenReply(){
        isOpenReply.value = !isOpenReply.value
        if (isOpenAddContent.value){
            isOpenAddContent.value = false
        }
    }
    fun updateIsOpenAddContent(){
        isOpenAddContent.value = !isOpenAddContent.value
    }
}