package com.prmto.borutoapp.data.repository

import androidx.paging.PagingData
import com.prmto.borutoapp.domain.model.Hero
import com.prmto.borutoapp.domain.repository.DataStoreOperations
import com.prmto.borutoapp.domain.repository.LocalDataSource
import com.prmto.borutoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local:LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remoteDataSource.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remoteDataSource.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId:Int):Hero{
        return local.getSelectedHero(heroId = heroId)
    }
}