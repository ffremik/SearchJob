package com.example.domain.usecases.getformat

import javax.inject.Inject

data class GetFormatUseCases @Inject constructor(
    val getFormatLookingTextUS: GetFormatLookingTextUS,
    val getFormatVacanciesTextUS: GetFormatVacanciesTextUS
)