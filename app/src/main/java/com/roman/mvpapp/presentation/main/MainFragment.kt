package com.roman.mvpapp.presentation.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roman.mvpapp.R
import com.roman.mvpapp.common.extension.showToast
import com.roman.mvpapp.databinding.FragmentMainBinding
import com.roman.mvpapp.di.AppComponent
import com.roman.mvpapp.presentation.main.adapter.MainCurrencyAdapter
import com.roman.mvpapp.presentation.model.CurrencyUi
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), MainContractView {

    private val binding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    private val presenter by moxyPresenter {
        presenterProvider.get()
    }

    private val currenciesAdapter by lazy {
        MainCurrencyAdapter(
            presenter::toDetailScreen
        )
    }

    init {
        AppComponent.get().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            currenciesRv.adapter = currenciesAdapter
            loadBtn.setOnClickListener {
                presenter.loadCurrencies()
            }
        }
    }

    override fun loadCurrencies(currencies: List<CurrencyUi>) {
        currenciesAdapter.submitList(currencies)
    }

    override fun getProgress(progressVisible: Boolean) {
        binding.progressBar.isVisible = progressVisible
    }

    override fun showToast(message: String) {
        requireContext().showToast(message)
    }

    override fun showError(visibility: Boolean, message: String) {
        with(binding){
            tvError.apply{
                isVisible = visibility
                text = message
            }
        }
    }

    override fun errorAction() {
        presenter.loadCurrencies()
    }
}