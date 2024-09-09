package com.example.domain.usecases.getformat

import javax.inject.Inject

class GetFormatVacanciesTextUS @Inject constructor(

) {
    fun invoke(number: Int): String {
        return when (number) {
            1 -> return "$number вакансия"
            in 2..4 -> return "$number вакансии"
            else -> return "$number вакансий"
        }
    }
}