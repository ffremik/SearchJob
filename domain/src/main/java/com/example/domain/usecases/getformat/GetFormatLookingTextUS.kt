package com.example.domain.usecases.getformat

import javax.inject.Inject

class GetFormatLookingTextUS @Inject constructor(

) {
    fun invoke(number: Int): String {
        return when (number) {
            in 2..4 -> "$number человека"
            else -> "$number человек"
        }
    }
}