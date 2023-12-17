package com.muhammed.cryptocurrencyapp.domain.repository

import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}