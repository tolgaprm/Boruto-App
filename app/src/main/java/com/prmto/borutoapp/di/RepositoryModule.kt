package com.prmto.borutoapp.di

import android.content.Context
import com.prmto.borutoapp.data.repository.DataStoreOperationsImpl
import com.prmto.borutoapp.data.repository.Repository
import com.prmto.borutoapp.domain.repository.DataStoreOperations
import com.prmto.borutoapp.domain.use_cases.UseCases
import com.prmto.borutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.prmto.borutoapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.prmto.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.prmto.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.prmto.borutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperationsImpl(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }
}