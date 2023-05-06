package com.example.aflammy.di

import com.example.aflammy.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ): MovieRepository

    @ViewModelScoped
    @Binds
    abstract fun bindOnBoardingRepository(
        onBoardingRepositoryImpl: OnBoardingRepositoryImpl
    ): OnBoardingRepository


    @ViewModelScoped
    @Binds
    abstract fun bindSeriesRepository(
        seriesRepositoryImp: SeriesRepositoryImp
    ): SeriesRepository

    @ViewModelScoped
    @Binds
    abstract fun bindAccountRepository(
        accountRepositoryImp: AccountRepositoryImp
    ): AccountRepository
}