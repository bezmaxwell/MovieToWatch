package com.example.sejaumguia.ui.main.dagger2.module

import com.example.sejaumguia.ui.main.model.DefaultRepository
import com.example.sejaumguia.ui.main.model.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(repository: DefaultRepository): Repository



}
