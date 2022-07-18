package com.prmto.borutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.prmto.borutoapp.data.repository.Repository
import com.prmto.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}