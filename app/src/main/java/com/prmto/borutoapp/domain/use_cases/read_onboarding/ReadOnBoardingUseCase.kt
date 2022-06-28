package com.prmto.borutoapp.domain.use_cases.read_onboarding

import com.prmto.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}