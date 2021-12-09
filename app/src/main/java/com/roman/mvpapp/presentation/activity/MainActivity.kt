package com.roman.mvpapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.roman.mvpapp.R
import com.roman.mvpapp.common.navigation.ScreenManager
import com.roman.mvpapp.di.AppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = object : AppNavigator(this, R.id.containerView) {
        override fun setupFragmentTransaction(
            screen: FragmentScreen,
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment,
        ) {
            fragmentTransaction.apply {
                setReorderingAllowed(true)
                setCustomAnimations(
                    android.R.animator.fade_in,
                    android.R.animator.fade_out
                )
            }
        }
    }

    init {
        AppComponent.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigatorHolder.setNavigator(navigator)
        if (savedInstanceState == null) {
            router.newRootScreen(ScreenManager.ToStartFragment)
        }
    }

    override fun onBackPressed() {
        router.exit()
    }
}
