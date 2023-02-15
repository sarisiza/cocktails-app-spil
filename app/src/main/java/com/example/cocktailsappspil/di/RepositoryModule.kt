package com.example.cocktailsappspil.di

import com.example.cocktailsappspil.rest.DrinksNetworkRepository
import com.example.cocktailsappspil.rest.DrinksNetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Provides dependency injection for the repository
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesDrinksNetworkRepository(
        drinksNetworkRepositoryImpl: DrinksNetworkRepositoryImpl
    ): DrinksNetworkRepository

}