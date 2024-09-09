package com.example.data.repository

import android.content.res.AssetManager
import android.util.Log
import com.example.data.data_remote.MockDataRemote
import com.example.data.mapper.toDomainModel
import com.example.domain.model.MockData
import com.example.domain.repository.RemoteRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Locale

class RemoteRepositoryImpl (
    private val assetManager: AssetManager
) : RemoteRepository {
    override suspend fun getMockData(): MockData? {
        return try {
            val json = withContext(Dispatchers.IO) {
                assetManager.open("mock.json").bufferedReader().use { it.readText() }
            }
            val type = object : TypeToken<MockDataRemote>() {}.type
            val remoteDate = Gson().fromJson<MockDataRemote>(json, type)
            remoteDate.toDomainModel()
        } catch (e: IOException) {
            Log.e("JobRepository", "Ошибка загрузки JSON", e)
            null
        }
    }

}