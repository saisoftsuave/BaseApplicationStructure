package com.saibabui.baseapplicationstructure.presentation.coin_list

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresExtension
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.playdate.child.android.base.BaseFragment
import com.saibabui.baseapplicationstructure.databinding.FragmentCoinListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CoinListFragment : BaseFragment<FragmentCoinListBinding>() {
    private val coinListViewModel: CoinListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getViewBinding(): FragmentCoinListBinding =
        FragmentCoinListBinding.inflate(layoutInflater)

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.coinsRecyclerView.layoutManager = LinearLayoutManager(context)
        val coinListAdapter = CoinListAdapter()
        binding.coinsRecyclerView.adapter = coinListAdapter

        lifecycleScope.launch {
            coinListViewModel.coinListState.collect {
                if (it.isLoading) {
                    binding.loader.visibility = View.VISIBLE
                }
                if (it.coins.isNotEmpty()) {
                    binding.loader.visibility = View.GONE
                    Log.d("The Coin details", it.coins.toString())
                    coinListAdapter.setAdapterList(it.coins)
                }
            }
        }
    }

    companion object {

    }
}