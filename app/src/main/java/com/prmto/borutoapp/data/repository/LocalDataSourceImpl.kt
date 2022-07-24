package com.prmto.borutoapp.data.repository

import com.prmto.borutoapp.data.local.BorutoDatabase
import com.prmto.borutoapp.domain.model.Hero
import com.prmto.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    private val borutoDatabase: BorutoDatabase
) : LocalDataSource {
    val heroDao = borutoDatabase.heroDao()
    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }


}