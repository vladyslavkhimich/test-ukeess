package com.khimich.ukeess.repository

import android.content.Context
import com.google.gson.Gson
import com.khimich.ukeess.models.json.PeopleData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PeopleRepository @Inject constructor(
    private val context: Context
) {
    suspend fun readJson(): PeopleData? = withContext(Dispatchers.IO) {
        return@withContext try {
            //We use this in Dispatchers.IO, so it is not blocking
            val jsonString = context.assets.open(ASSETS_FILE_NAME).bufferedReader().use {
                it.readText()
            }
            val peopleData = Gson().fromJson(jsonString, PeopleData::class.java)
            peopleData
        } catch (exception: Exception) {
            null
        }
    }

    companion object {
        const val ASSETS_FILE_NAME = "people_data.json"
    }
}