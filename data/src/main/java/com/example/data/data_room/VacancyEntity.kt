package com.example.data.data_room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(tableName = "vacancy")
@TypeConverters(StringTypeConverter::class)
data class VacancyEntity(
    @PrimaryKey()
    val id: String,
    val lookingNumber: Int? = 0,
    val title: String,
    @Embedded
    val address: AddressEntity,
    val company: String,
    @Embedded
    val experience: ExperienceEntity,
    val publishedDate: String,
    var isFavorite: Boolean,
    @Embedded
    val salary: SalaryEntity,
    val schedules: List<String>,
    val questions: List<String>,
    val appliedNumber: Int? = null,
    val description: String? = null,
    val responsibilities: String
)

@Entity(tableName = "addresses")
data class AddressEntity(
    @PrimaryKey()
    val town: String,
    val street: String,
    val house: String
)

@Entity(tableName = "experiences")
data class ExperienceEntity(
    @PrimaryKey()
    val previewText: String,
    val text: String
)

@Entity(tableName = "salaries")
data class SalaryEntity(
    val short: String? = null,
    @PrimaryKey()
    val full: String,
)

class StringTypeConverter() {
    @TypeConverter
    fun stringListToString(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun stringToStringList(value: String): List<String> {
        return value.split(",").toList()
    }
}