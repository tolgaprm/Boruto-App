package com.prmto.borutoapp.domain.repository

import androidx.paging.PagingData
import com.prmto.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes():Flow<PagingData<Hero>>

    fun searchHeroes():Flow<PagingData<Hero>>
}