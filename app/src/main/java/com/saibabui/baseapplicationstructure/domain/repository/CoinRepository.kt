package com.saibabui.baseapplicationstructure.domain.repository

import com.saibabui.baseapplicationstructure.data.remote.dto.CoinDetailsDto
import com.saibabui.baseapplicationstructure.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}