package com.ap.watchtogive.domain.use_case

import com.ap.watchtogive.common.Resource
import com.ap.watchtogive.data.dto.toCharity
import com.ap.watchtogive.domain.model.Charity
import com.ap.watchtogive.domain.repository.CharityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharitiesByNameUseCase @Inject constructor(
    private val repository: CharityRepository
) {
    operator fun invoke(charityName : String): Flow<Resource<List<Charity>>> = flow{
        try{
            emit(Resource.Loading())
            val charities = repository.getCharitiesByName(charityName = charityName).map { it.toCharity() }
            emit(Resource.Success(charities))
        } catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}