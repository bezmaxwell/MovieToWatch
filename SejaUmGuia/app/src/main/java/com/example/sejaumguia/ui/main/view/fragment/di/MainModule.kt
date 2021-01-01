package com.example.sejaumguia.ui.main.view.fragment.di

import androidx.lifecycle.ViewModel
import com.example.sejaumguia.ui.main.dagger2.ViewModelKey
import com.example.sejaumguia.ui.main.dagger2.scope.MainScope
import com.example.sejaumguia.ui.main.view.fragment.viewModel.CategoriesViewModel
import com.example.sejaumguia.ui.main.view.fragment.viewModel.DescriptionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    fun bindCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DescriptionViewModel::class)
    fun bindRegistrationViewModel(viewModel: DescriptionViewModel): ViewModel

}