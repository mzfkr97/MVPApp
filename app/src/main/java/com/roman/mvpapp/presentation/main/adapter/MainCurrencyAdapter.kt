package com.roman.mvpapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roman.mvpapp.databinding.ItemCurrencyMainBinding
import com.roman.mvpapp.presentation.model.CurrencyUi

class MainCurrencyAdapter(
    val itemClick: (item: CurrencyUi) -> Unit,
) : ListAdapter<CurrencyUi, MainCurrencyAdapter.Holder>(DIFF_ITEM_CALLBACK) {

    companion object {
        val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<CurrencyUi>() {
            override fun areItemsTheSame(oldItem: CurrencyUi, newItem: CurrencyUi) = oldItem.id == newItem.id
            override fun getChangePayload(oldItem: CurrencyUi, newItem: CurrencyUi) = Any()
            override fun areContentsTheSame(oldItem: CurrencyUi, newItem: CurrencyUi) = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCurrencyMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(currentList[position])
    }

    inner class Holder(private val binding: ItemCurrencyMainBinding) : RecyclerView.ViewHolder(binding.root) {

        private val item: CurrencyUi
            get() = getItem(bindingAdapterPosition)

        init {
            binding.root.setOnClickListener {
                itemClick(item)
            }
        }

        fun bind(model: CurrencyUi) {
            with(binding) {
                textCurName.text = model.name
                textCodeAbbreviation.text = model.abbreviation
                textScaleAndName.text = model.scaleAndName
                textCurOfficialRate.text = model.officialRate
            }
        }
    }
}
