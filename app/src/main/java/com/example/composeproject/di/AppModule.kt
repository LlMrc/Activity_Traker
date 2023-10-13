package com.example.composeproject.di

import android.app.Application
import com.example.composeproject.data.manager.LocalUserImpl
import com.example.composeproject.domain.manager.LocalUserManager
import com.example.composeproject.domain.manager.usecases.AppEntryUseCases
import com.example.composeproject.domain.manager.usecases.ReadAppEntry
import com.example.composeproject.domain.manager.usecases.SaveEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUsesCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveEntry = SaveEntry(localUserManager)
    )
}