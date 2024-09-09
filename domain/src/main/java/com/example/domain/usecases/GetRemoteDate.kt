package com.example.domain.usecases

import com.example.domain.model.MockData
import com.example.domain.repository.RemoteRepository
import java.text.SimpleDateFormat
import java.util.Locale

class GetRemoteDate (
    private val repository: RemoteRepository
) {
    suspend fun invoke(): MockData? {
        val mockData = repository.getMockData()
        mockData?.vacancies?.forEach { vacancy ->
            vacancy.publishedDate = formatDate(vacancy.publishedDate)
        }
        return mockData
    }

    private fun formatDate(
        dateString: String,
        inputFormat: String = "yyyy-MM-dd",
        outputFormat: String = "dd MMMM"
    ): String {
        val inputFormatter = SimpleDateFormat(inputFormat, Locale.getDefault())
        val outputFormatter = SimpleDateFormat(outputFormat, Locale.getDefault())
        val date = inputFormatter.parse(dateString)
        return outputFormatter.format(date).replaceFirst("0", "")
    }
}