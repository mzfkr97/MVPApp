package com.roman.mvpapp.presentation.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roman.mvpapp.R
import com.roman.mvpapp.common.extension.showToast
import com.roman.mvpapp.databinding.FragmentDetailsBinding
import com.roman.mvpapp.di.AppComponent
import com.roman.mvpapp.presentation.model.CurrencyUi
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DetailsFragment : MvpAppCompatFragment(R.layout.fragment_details), DetailsContractView {

    companion object {

        private const val ARG_DETAILS_FRAGMENT = "DetailsFragment.ARG"

        fun newInstance(args: CurrencyUi): DetailsFragment {
            return DetailsFragment().apply {
                arguments = bundleOf(
                    ARG_DETAILS_FRAGMENT to args
                )
            }
        }
    }

    @Inject
    lateinit var factory: DetailsPresenterFactory

    private val presenter by moxyPresenter(name = "DetailsPresenter") {
        val args = requireNotNull(
            requireArguments().getParcelable<CurrencyUi>(ARG_DETAILS_FRAGMENT)
        )
        factory.create(args)
    }

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    init {
        AppComponent.get().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
//        binding.textView.text = args.toString()
//        requireActivity().showToast(args.toString())
    }

    override fun showCurrency(currencies: CurrencyUi) {
        binding.textView.text = currencies.toString()
        requireActivity().showToast(currencies.toString())
    }

    override fun errorAction() {
        TODO("Not yet implemented")
    }
}