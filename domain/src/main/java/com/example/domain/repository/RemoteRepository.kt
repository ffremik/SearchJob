package com.example.domain.repository

import com.example.domain.model.MockData

interface RemoteRepository {
    suspend fun getMockData(): MockData?
}