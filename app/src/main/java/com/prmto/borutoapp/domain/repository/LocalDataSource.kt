package com.prmto.borutoapp.domain.repository

import com.prmto.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}