package com.example.data.data_remote

data class VacancyRemote(
    val id: String,
    val lookingNumber: Int? = 0,
    val title: String,
    val address: AddressRemote,
    val company: String,
    val experience: ExperienceRemote,
    val publishedDate: String,
    var isFavorite: Boolean,
    val salary: SalaryRemote,
    val schedules: List<String>,
    val questions: List<String>,
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String
)



data class AddressRemote(
    val town: String,
    val street: String,
    val house: String
)

data class ExperienceRemote(
    val previewText: String,
    val text: String
)


data class SalaryRemote(
    val short: String? = null,
    val full: String,
)
