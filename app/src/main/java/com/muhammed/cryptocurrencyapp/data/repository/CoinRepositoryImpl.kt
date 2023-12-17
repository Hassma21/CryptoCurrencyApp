package com.muhammed.cryptocurrencyapp.data.repository

import com.muhammed.cryptocurrencyapp.data.remote.CoinPaprikaAPI
import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDto
import com.muhammed.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api : CoinPaprikaAPI) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}