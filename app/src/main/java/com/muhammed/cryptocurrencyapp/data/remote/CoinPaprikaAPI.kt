package com.muhammed.cryptocurrencyapp.data.remote

import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailDto
}