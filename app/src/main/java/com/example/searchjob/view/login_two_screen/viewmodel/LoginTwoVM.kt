package com.example.searchjob.view.login_two_screen.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.searchjob.R
import kotlinx.coroutines.flow.MutableStateFlow

class LoginTwoVM : ViewModel(){
    val isValid = MutableStateFlow(false)
    val colorTextButton = MutableStateFlow(R.color.basic_grey)


    val inputCodeUser = mutableStateListOf<String>("", "", "", "")

    fun addUserCode(index: Int, userInput: String) {
        inputCodeUser[index] = userInput
    }

    fun isValidUserCode() {
        var isVal = true
        for (code in inputCodeUser){
            if (code.isEmpty()) {
                isVal = false
            }
        }
        if (isVal) {
            isValid.value = true
            colorTextButton.value = R.color.white
        } else {
            isValid.value = false
            colorTextButton.value = R.color.basic_grey
        }

    }
}