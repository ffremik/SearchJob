package com.example.searchjob.view.mainscreen.model

import com.example.domain.model.MockData

sealed interface StateMainScreen {
    data class Success(val mockData: MockData) : StateMainScreen
    object Error: StateMainScreen
    object Loading: StateMainScreen
}