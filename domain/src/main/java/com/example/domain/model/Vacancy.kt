package com.example.domain.model

data class Vacancy(
    val id: String,
    val lookingNumber: Int? = 0,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    var publishedDate: String,
    var isFavorite: Boolean,
    val salary: Salary,
    val schedules: List<String>,
    val questions: List<String>,
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String
)



data class Address(
    val town: String,
    val street: String,
    val house: String
)

data class Experience(
    val previewText: String,
    val text: String
)


data class Salary(
    val short: String? = null,
    val full: String,
)