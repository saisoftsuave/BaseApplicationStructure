package com.saibabui.baseapplicationstructure.presentation.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saibabui.baseapplicationstructure.common.NetworkResult
import com.saibabui.baseapplicationstructure.domain.repository.CoinRepository
import com.saibabui.baseapplicationstructure.domain.usecases.get_coin.GetCoinsUseCase
import com.saibabui.baseapplicationstructure.presentation.coin_detail.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase, private val coinRepository: CoinRepository
) : ViewModel() {
    private val _coinListState = MutableStateFlow(CoinListState())
    val coinListState: StateFlow<CoinListState> = _coinListState

    init {
        viewModelScope.launch {
            while (true) {
                withContext(Dispatchers.IO) {
                    getCoins()
                    delay(1000)
                }
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCoins() {
        getCoinsUseCase().collectLatest {
            when (it) {
                is NetworkResult.Success -> {
                    _coinListState.value = CoinListState(coins = it.data ?: emptyList())
                }

                is NetworkResult.Loading -> {
                    _coinListState.value = CoinListState(isLoading = true)
                }

                else -> {
                    _coinListState.value = CoinListState(error = it.message ?: "Error")
                }
            }
        }
    }


}