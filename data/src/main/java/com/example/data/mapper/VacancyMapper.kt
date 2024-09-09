package com.example.data.mapper

import com.example.data.data_room.AddressEntity
import com.example.data.data_room.ExperienceEntity
import com.example.data.data_room.SalaryEntity
import com.example.data.data_room.VacancyEntity
import com.example.domain.model.Address
import com.example.domain.model.Experience
import com.example.domain.model.Salary
import com.example.domain.model.Vacancy

fun Vacancy.toEntity(): VacancyEntity {
    return VacancyEntity(
        id = this.id,
        lookingNumber = this.lookingNumber,
        title = this.title,
        address = this.address.toEntity(),
        company = this.company,
        experience = this.experience.toEntity(),
        publishedDate = this.publishedDate,
        isFavorite = this.isFavorite,
        salary = this.salary.toEntity(),
        schedules = this.schedules,
        questions = this.questions,
        appliedNumber = this.appliedNumber,
        description = this.description,
        responsibilities = this.responsibilities
    )
}

fun Address.toEntity(): AddressEntity {
    return AddressEntity(
        town = this.town,
        street = this.street,
        house = this.house
    )
}

fun Experience.toEntity(): ExperienceEntity {
    return ExperienceEntity(
        previewText = this.previewText,
        text = this.text
    )
}

fun Salary.toEntity(): SalaryEntity {
    return SalaryEntity(
        short = this.short,
        full = this.full
    )
}