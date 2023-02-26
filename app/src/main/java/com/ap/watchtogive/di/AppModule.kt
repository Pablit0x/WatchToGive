package com.ap.watchtogive.di

import com.ap.watchtogive.common.Constants
import com.ap.watchtogive.data.CharityCommissionApi
import com.ap.watchtogive.data.repository.CharityRepositoryImpl
import com.ap.watchtogive.domain.repository.CharityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCharityCommissionApi() : CharityCommissionApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharityCommissionApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCharityRepository(charityApi: CharityCommissionApi) : CharityRepository{
        return CharityRepositoryImpl(charityApi)
    }

}