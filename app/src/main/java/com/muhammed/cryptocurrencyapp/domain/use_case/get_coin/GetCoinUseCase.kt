package com.muhammed.cryptocurrencyapp.domain.use_case.get_coin

import com.muhammed.cryptocurrencyapp.data.remote.toCoin
import com.muhammed.cryptocurrencyapp.data.remote.toCoinDetail
import com.muhammed.cryptocurrencyapp.domain.model.Coin
import com.muhammed.cryptocurrencyapp.domain.model.CoinDetail
import com.muhammed.cryptocurrencyapp.domain.repository.CoinRepository
import com.muhammed.cryptocurrencyapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error("Check Your Internet Connection"))
        }
    }
}