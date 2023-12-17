package com.muhammed.cryptocurrencyapp.data.remote

import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.muhammed.cryptocurrencyapp.data.remote.dto.CoinDto
import com.muhammed.cryptocurrencyapp.domain.model.Coin
import com.muhammed.cryptocurrencyapp.domain.model.CoinDetail

fun CoinDto.toCoin() : Coin {
    return  Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDetailDto.toCoinDetail() : CoinDetail {
    return  CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}