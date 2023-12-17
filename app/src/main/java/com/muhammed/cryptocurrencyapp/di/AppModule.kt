package com.muhammed.cryptocurrencyapp.di

import com.muhammed.cryptocurrencyapp.data.remote.CoinPaprikaAPI
import com.muhammed.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.muhammed.cryptocurrencyapp.domain.repository.CoinRepository
import com.muhammed.cryptocurrencyapp.utils.Constant.BASE_URL
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
    fun provideCoinApi(): CoinPaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api = api)
    }
}