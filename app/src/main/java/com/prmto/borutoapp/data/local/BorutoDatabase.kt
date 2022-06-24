package com.prmto.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prmto.borutoapp.data.local.dao.HeroDao
import com.prmto.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.prmto.borutoapp.domain.model.Hero
import com.prmto.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}