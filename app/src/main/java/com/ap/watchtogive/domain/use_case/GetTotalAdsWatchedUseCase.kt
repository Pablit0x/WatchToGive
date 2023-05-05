package com.ap.watchtogive.domain.use_case

import com.ap.watchtogive.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalAdsWatchedUseCase @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) {
    suspend operator fun invoke(): Flow<Long> {
        return firebaseRepository.getTotalAdsWatched()
    }
}