package com.saibabui.baseapplicationstructure.di

import com.saibabui.baseapplicationstructure.common.NetworkManager
import com.saibabui.baseapplicationstructure.data.remote.CoinPaprikaApi
import com.saibabui.baseapplicationstructure.data.repository.CoinRepositoryImpl
import com.saibabui.baseapplicationstructure.domain.repository.CoinRepository
import com.saibabui.baseapplicationstructure.domain.usecases.get_coin.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return NetworkManager.apiService()
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository)
    }
}