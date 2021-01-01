package com.example.sejaumguia.ui.main.dagger2.component

import android.content.Context
import com.example.sejaumguia.ui.main.dagger2.ViewModelBuilderModule
import com.example.sejaumguia.ui.main.dagger2.module.DataModule
import com.example.sejaumguia.ui.main.view.fragment.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules= [DataModule::class,ViewModelBuilderModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationComponent: Context):ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory

}

@Module(subcomponents = [MainComponent::class])
object SubcomponentsModule
