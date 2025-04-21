package com.saibabui.baseapplicationstructure.presentation.coin_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saibabui.baseapplicationstructure.databinding.SingleCoinCardBinding
import com.saibabui.baseapplicationstructure.domain.model.Coin

class CoinListAdapter : RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {

    private var list = listOf<Coin>()


    fun setAdapterList(list: List<Coin>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleCoinCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.coinPosition.text = item.id
        holder.coinName.text = item.name
        holder.symbol.text = item.symbol
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(binding: SingleCoinCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val coinPosition = binding.coinPosition
        val coinName = binding.coinName
        val symbol = binding.symbol


    }
}
