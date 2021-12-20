package com.roman.mvpapp.di

import android.content.Context
import com.roman.mvpapp.di.module.*
import com.roman.mvpapp.presentation.activity.MainActivity
import com.roman.mvpapp.presentation.app.MyApplication
import com.roman.mvpapp.presentation.details.DetailsFragment
import com.roman.mvpapp.presentation.main.MainFragment
import com.roman.mvpapp.presentation.main.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DataBaseModule::class,
        MainFragmentModule::class,
        ToolsModule::class,
        RepositoryModule::class,
        RetrofitModule::class,
        NavigationModule::class,
        InteractorsModule::class,
        DataSourcesModule::class,
    ]
)

@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

    fun inject(where: MyApplication)
    fun inject(where: MainActivity)
    fun inject(where: MainFragment)
    fun inject(where: DetailsFragment)

    companion object {
        private var component: AppComponent? = null

        fun init(context: Context) {
            component ?: DaggerAppComponent.builder()
                .context(context).build().apply {
                    component = this
                }
        }

        fun get(): AppComponent {
            return component ?: throw NotImplementedError("AppComponent: Not Implemented Error")
        }
    }
}
