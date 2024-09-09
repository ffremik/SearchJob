package com.example.searchjob.view.login_one_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.searchjob.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginOneVM : ViewModel() {
    private val _inputUser = MutableStateFlow("")
    val inputUser = _inputUser.asStateFlow()

    private val _colorActionText = MutableStateFlow(R.color.basic_grey)
    val colorActionText = _colorActionText.asStateFlow()

    private val _isValidEmail = MutableStateFlow(false)
    val isValidEmail = _isValidEmail.asStateFlow()


    fun updateInputTextUser(userText: String) {
        _inputUser.value = userText
        if (inputUser.value.isNotEmpty()) {
            _colorActionText.value = R.color.white

            _isValidEmail.value = false
        } else {
            _colorActionText.value = R.color.basic_grey
            _isValidEmail.value = false
        }
    }

    fun isValidEmail(): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        _isValidEmail.value = !emailRegex.matches(inputUser.value)
        return isValidEmail.value
    }

    fun clearTextField() {
        _inputUser.value = ""
        _isValidEmail.value = false
        _colorActionText.value = R.color.basic_grey
    }
}