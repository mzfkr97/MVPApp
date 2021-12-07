package com.roman.mvpapp.presentation.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.roman.mvpapp.R
import com.roman.mvpapp.common.extension.showToast
import com.roman.mvpapp.databinding.FragmentDetailsBinding
import com.roman.mvpapp.presentation.main.model.CurrencyUi

class DetailsFragment : Fragment(R.layout.fragment_details) {

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

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = requireNotNull(
            requireArguments().getParcelable<CurrencyUi>(ARG_DETAILS_FRAGMENT)
        )
        binding.textView.text = args.toString()
        requireActivity().showToast(args.toString())
    }
}
