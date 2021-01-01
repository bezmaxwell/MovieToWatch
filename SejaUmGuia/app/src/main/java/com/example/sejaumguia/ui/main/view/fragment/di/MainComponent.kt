package com.example.sejaumguia.ui.main.view.fragment.di

import com.example.sejaumguia.ui.main.dagger2.scope.MainScope
import com.example.sejaumguia.ui.main.view.main.MainActivity
import com.example.sejaumguia.ui.main.view.fragment.ui.CategoriesFragment
import com.example.sejaumguia.ui.main.view.fragment.ui.DescriptionFragment
import dagger.Subcomponent

@MainScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: CategoriesFragment)
    fun inject(fragment: DescriptionFragment)


}