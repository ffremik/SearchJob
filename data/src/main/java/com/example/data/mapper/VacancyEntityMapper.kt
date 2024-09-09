package com.example.data.mapper

import com.example.data.data_room.AddressEntity
import com.example.data.data_room.ExperienceEntity
import com.example.data.data_room.SalaryEntity
import com.example.data.data_room.VacancyEntity
import com.example.domain.model.Address
import com.example.domain.model.Experience
import com.example.domain.model.Salary
import com.example.domain.model.Vacancy

fun VacancyEntity.toVacancy(): Vacancy {
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

fun AddressEntity.toVacancy(): Address {
    return Address(
        town = this.town,
        street = this.street,
        house = this.house
    )
}

fun ExperienceEntity.toVacancy(): Experience {
    return Experience(
        previewText = this.previewText,
        text = this.text
    )
}

fun SalaryEntity.toVacancy(): Salary {
    return Salary(
        short = this.short,
        full = this.full
    )
}