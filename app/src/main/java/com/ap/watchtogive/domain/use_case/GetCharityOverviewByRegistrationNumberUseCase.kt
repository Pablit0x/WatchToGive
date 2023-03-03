package com.ap.watchtogive.domain.use_case

import com.ap.watchtogive.common.Resource
import com.ap.watchtogive.data.dto.toCharityDetail
import com.ap.watchtogive.domain.model.CharityDetail
import com.ap.watchtogive.domain.repository.CharityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharityOverviewByRegistrationNumberUseCase @Inject constructor(
    private val repository: CharityRepository
) {
    operator fun invoke(regNumber : Int): Flow<Resource<CharityDetail>> = flow{
        try{
            emit(Resource.Loading())
            val coinDetails = repository.getCharityOverviewByRegisteredNumber(regNumber).toCharityDetail()
            emit(Resource.Success(coinDetails))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}