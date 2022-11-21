package com.example.nightlife.repositories

import android.text.Html
import com.example.nightlife.model.Bar
import com.example.nightlife.service.BarApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class BarRep @Inject internal constructor(private val barApi: BarApi) {

    fun getBars(): Flow<List<Bar>> = flow {
        emit (
            try {
                barApi.getBars().map {
                    Bar(it.id, it.name, it.rating)
                }
            } catch (e: Exception) {
                println(e.stackTrace)
                emptyList()
            }
        )
    }
}
