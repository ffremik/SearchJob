package com.example.domain.model

data class MockData(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>,
)

data class Offer(
    val id: String? = null,
    val title: String,
    val button: Button? = null,
    val link: String
)

data class Button(
    val text: String
)