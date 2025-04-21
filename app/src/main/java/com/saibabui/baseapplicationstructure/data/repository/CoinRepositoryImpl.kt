package com.saibabui.baseapplicationstructure.data.repository

import com.saibabui.baseapplicationstructure.data.remote.CoinPaprikaApi
import com.saibabui.baseapplicationstructure.data.remote.dto.CoinDetailsDto
import com.saibabui.baseapplicationstructure.data.remote.dto.CoinDto
import com.saibabui.baseapplicationstructure.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return coinPaprikaApi.getCoinDetails(coinId)
    }

}