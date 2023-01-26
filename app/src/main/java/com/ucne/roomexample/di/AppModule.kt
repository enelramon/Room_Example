package com.ucne.roomexample.di

import android.content.Context
import androidx.room.Room
import com.ucne.roomexample.data.local.RoomExpampleDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDatabase( @ApplicationContext context: Context ): RoomExpampleDb{
        return Room.databaseBuilder(
            context,
            RoomExpampleDb::class.java,
            "RoomExample.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesOcupacionDao(db: RoomExpampleDb) = db.ocupacionDao


}