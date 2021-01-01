package com.example.sejaumguia.ui.main.view.app

import android.app.Application
import com.example.sejaumguia.ui.main.dagger2.component.ApplicationComponent
import com.example.sejaumguia.ui.main.dagger2.component.DaggerApplicationComponent

class MyApp:Application(){

    lateinit var appComponent:ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }

}