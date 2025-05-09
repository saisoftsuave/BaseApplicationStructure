package com.saibabui.baseapplicationstructure.presentation.coin_detail

import com.saibabui.baseapplicationstructure.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
