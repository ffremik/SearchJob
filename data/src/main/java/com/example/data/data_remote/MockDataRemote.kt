package com.example.data.data_remote

data class MockDataRemote(
    val offers: List<OfferRemote>,
    val vacancies: List<VacancyRemote>,
)

data class OfferRemote(
    val id: String? = null,
    val title: String,
    val button: ButtonRemote? = null,
    val link: String
)

data class ButtonRemote(
    val text: String
)