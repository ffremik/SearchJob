package com.example.data.mapper

import com.example.data.data_remote.AddressRemote
import com.example.data.data_remote.ButtonRemote
import com.example.data.data_remote.ExperienceRemote
import com.example.data.data_remote.MockDataRemote
import com.example.data.data_remote.OfferRemote
import com.example.data.data_remote.SalaryRemote
import com.example.data.data_remote.VacancyRemote
import com.example.data.data_room.AddressEntity
import com.example.data.data_room.ExperienceEntity
import com.example.data.data_room.SalaryEntity
import com.example.data.data_room.VacancyEntity
import com.example.domain.model.Address
import com.example.domain.model.Button
import com.example.domain.model.Experience
import com.example.domain.model.MockData
import com.example.domain.model.Offer
import com.example.domain.model.Salary
import com.example.domain.model.Vacancy

fun MockDataRemote.toDomainModel(): MockData {
    return MockData(
        offers = this.offers.map { it.toDomainModel() },
        vacancies = this.vacancies.map {it.toDomainModel() }
    )
}

fun OfferRemote.toDomainModel(): Offer {
    return Offer(
        id = this.id,
        title = this.title,
        button = this.button?.toDomainModel(),
        link = this.link
    )
}

fun VacancyRemote.toDomainModel(): Vacancy {
    return Vacancy(
        id = this.id,
        lookingNumber = this.lookingNumber,
        title = this.title,
        address = this.address.toVacancy(),
        company = this.company,
        experience = this.experience.toVacancy(),
        publishedDate = this.publishedDate,
        isFavorite = this.isFavorite,
        salary = this.salary.toVacancy(),
        schedules = this.schedules,
        questions = this.questions,
        appliedNumber = this.appliedNumber,
        description = this.description,
        responsibilities = this.responsibilities
    )
}
fun AddressRemote.toVacancy(): Address {
    return Address(
        town = this.town,
        street = this.street,
        house = this.house
    )
}

fun ExperienceRemote.toVacancy(): Experience {
    return Experience(
        previewText = this.previewText,
        text = this.text
    )
}

fun SalaryRemote.toVacancy(): Salary {
    return Salary(
        short = this.short,
        full = this.full
    )
}

fun ButtonRemote.toDomainModel(): Button {
    return Button(
        text = this.text
    )
}