package com.roman.mvpapp.common.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.roman.mvpapp.presentation.details.DetailsFragment
import com.roman.mvpapp.presentation.main.MainFragment
import com.roman.mvpapp.presentation.model.CurrencyUi

sealed interface ScreenManager : FragmentScreen {

    object ToStartFragment : ScreenManager {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return MainFragment()
        }
    }

    data class ToDetailsFragment(val item: CurrencyUi) : ScreenManager {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return DetailsFragment.newInstance(item)
        }
    }
}
