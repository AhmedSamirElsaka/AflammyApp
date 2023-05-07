package com.example.aflammy.di

import android.content.Context
import androidx.room.Room
import com.example.aflammy.data.local.DataStorePreferences
import com.example.aflammy.data.local.database.Converters
import com.example.aflammy.data.local.database.AflammyDataBase
import com.example.aflammy.data.local.database.daos.ActorDao
import com.example.aflammy.data.local.database.daos.MovieDao
import com.example.aflammy.data.local.database.daos.SeriesDao
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(
        @ApplicationContext context: Context,
        converters: Converters,
    ): AflammyDataBase =
        Room.databaseBuilder(context, AflammyDataBase::class.java, "MovieDatabase")
            .addTypeConverter(converters)
            .build()

    @Singleton
    @Provides
    fun provideMovieDao(aflammyDataBase: AflammyDataBase): MovieDao {
        return aflammyDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideActorDao(aflammyDataBase: AflammyDataBase): ActorDao {
        return aflammyDataBase.actorDao()
    }

    @Singleton
    @Provides
    fun provideSeriesDao(aflammyDataBase: AflammyDataBase): SeriesDao {
        return aflammyDataBase.seriesDao()
    }

    @Singleton
    @Provides
    fun provideConverters(gson: Gson): Converters {
        return Converters(gson)
    }

    @Singleton
    @Provides
    fun provideDataStorePreferences(@ApplicationContext context: Context) =
        DataStorePreferences(context)
}